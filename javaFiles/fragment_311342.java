import javax.swing.JOptionPane;

public class OptionPaneEgWithEnums {
   public static void main(String[] args) {
      int option = JOptionPane.showOptionDialog(null, "Title", "Message",
            JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,
            State.values(), State.values()[0]);
      if (option == JOptionPane.CLOSED_OPTION) {
         // user closed the JOptionPane without selecting
      } else {
         State state = State.values()[option];
         doAction(state);
         // code to do something based selected state
      }
   }

   private static void doAction(State state) {
      System.out.println("The user has selected to " + state);
   }
}

enum State {
   AHEAD("Go Ahead"), BACK("Go Back"), FORWARD("Go Forward"), CLOSE("Close Me");
   private State(String text) {
      this.text = text;
   }

   private String text;

   public String getText() {
      return text;
   }

   @Override
   public String toString() {
      return text;
   }
}