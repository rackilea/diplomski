import java.awt.event.ActionEvent;

public class MvcControl {
   private MvcModel model;

   public MvcControl(MvcModel model) {
      this.model = model;
   }

   // all this simplistic control does is change the state of the model, that's it
   public void startButtonActionPerformed(ActionEvent ae) {
      model.setState(State.START);
   }

   public void endButtonActionPerformed(ActionEvent ae) {
      model.setState(State.END);
   }
}