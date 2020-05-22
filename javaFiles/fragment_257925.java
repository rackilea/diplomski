import java.util.List;
import java.util.ArrayList;



/** The Invoker class */
class Switch {
    List<Command> commandList = new ArrayList<Command>();
    Switch() {
        commandList.add(new IncreementCommand()); //Level 1 Operation
        commandList.add(new MultipleCommand());
        commandList.add(new DecrementCommand());
        //If level 4 need same operation like level 1
        commandList.add(new IncreementCommand()); 

    }

    public int execute(CustomMarker a, int lvl){
        int rtr = 0;
        Command cmd = commandList.get(lvl-1); //Level 1 means 1st operation
        return execute(a, lvl, rtr, cmd);
    }


    /** The Command interface */
    interface Command {
        int execute(int data, int rtr);
    }

   private int execute(CustomMarker a, int lvl, int rtr, Command cmd){
       if(lvl == 0){
           return cmd.execute(a.getData(), rtr);
       }
       else {
           lvl--;
           if(a.getSubData() != null && a.getSubData().length>0){
               for (int i = 0; i < a.getSubData().length; i++) {
                 rtr = execute(a.getSubData()[i], lvl, rtr, cmd);
               }
           }
           return rtr;
       }
   }

   //Inner classes
   class IncreementCommand implements Command {
       @Override    // Command
       public int execute(int data, int rtr) {
          return rtr+data;
       }
    }

    /** The Command for turning off the light - ConcreteCommand #2 */
    class MultipleCommand implements Command {
        @Override    // Command
        public int execute(int data, int rtr) {
           return rtr*data;
        }
    }

    /** The Command for turning off the light - ConcreteCommand #2 */
    class DecrementCommand implements Command {
        @Override    // Command
        public int execute(int data, int rtr) {
           return rtr-data;
        }
    }
}

/** The Custom Marker interface */
interface CustomMarker {
    //It will return your int a_field or b_field
   public int getData();
   public CustomMarker[] getSubData();
}


//Level 1
class A implements CustomMarker {  int a_field; B[] bs;
    public int getData() {
        return a_field;
    }
    public CustomMarker[] getSubData() {
        return bs;
    }
}
//Level 2
class B implements CustomMarker {  int b_field; C[] cs;
    public int getData() {
        return b_field;
    }
    public CustomMarker[] getSubData() {
        return cs;
    }
}
//Level 3
class C implements CustomMarker {  int c_field; D[] ds;
    public int getData() {
        return c_field;
    }
    public CustomMarker[] getSubData() {
        return ds;
    }
}
//Level 4
class D implements CustomMarker {  int d_field; 
    public int getData() {
        return d_field;
    }
    public CustomMarker[] getSubData() {
        return null;
    }
}


/* The test class or client */
public class TestClass {
   static A[] as;
   public static void main(String[] args){



      CustomMarker topLevel = new CustomMarker() {
        @Override
        public int getData() {
            // TODO Auto-generated method stub
            return 0;
        }
        @Override
        public CustomMarker[] getSubData() {
            return as;
        }
      };

      Switch mySwitch = new Switch();
      for(int n=1;n<=3;n++){ 
          mySwitch.execute(topLevel, n); 
      }
   }
}