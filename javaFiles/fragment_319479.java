import java.util.*;

/** 
  A basic 'Command' class for testing
*/
class Command {
  private String id;
  public Command (String pId) {
    this.id = pId;
  }
  public void execute () {
    System.out.println ("Command: "+id);
  }
}

/** The class that does the random selection bit of magic */
public class CommandDist {

  /** an internal helper class to manage proportions and the command */
  class Cmd {
    Command command;                 // the command that will get executed
    double assignedProportion;       // weight assigned when added
    double cumulativeProportion;     // recalculated later to between 0 and 1

    public Cmd (Command c, double proportion) {
      this.command = c;
      this.assignedProportion = proportion;
      this.cumulativeProportion = 0.0;
    }
  }

  // the list I'm using 
  private List<Cmd> commandDistribution = new ArrayList<Cmd>();
  private java.util.Random myRandom = new java.util.Random();

  void addCommand (Command command, double proportion) {
    commandDistribution.add ( new Cmd (command, proportion));
  }

  // ** MUST BE CALLED **, after adding all the commands, to normalise the proportions.
  // you could do this tidier by setting a flag in add, and checking it in
  // getNextCommandToExecute
  void normaliseProportion() {
    double total = 0;
    double cumulativeProp = 0;
    for (Cmd cmd: commandDistribution) {
       total += cmd.assignedProportion;
    }
    for (Cmd cmd: commandDistribution) {
       cumulativeProp += cmd.assignedProportion/total;
       cmd.cumulativeProportion = cumulativeProp;
    }
  }


  private Command getNextCommandToExecute () {
    double d = myRandom.nextDouble();
    for (Cmd cmd: commandDistribution) {
      if (d < cmd.cumulativeProportion) {
        return cmd.command;
      }
    }
    // theoretically, should not get here.  Never rely on theoretically.
    return commandDistribution.get(0).command;

  }

  public static void main (String [] args) {
    CommandDist cd = new CommandDist();
    Command c; 

    cd.addCommand (new Command ("A"), 50.0);
    cd.addCommand (new Command ("B"), 20.0);
    cd.addCommand (new Command ("C"), 15.0);
    cd.addCommand (new Command ("D"), 10.0);

    cd.normaliseProportion();


    for (int i = 0; i < 10000; i++) {
       c = cd.getNextCommandToExecute();
       c.execute();
    }

  }
}