public class Controller {
     Model m;
     public ActionListener getDeleteListener () {
         return new ActionListener() {
             @Override public void actionPerformed (ActionEvent e) {
                 m.deleteSomething();
             }
         };
     }
 }