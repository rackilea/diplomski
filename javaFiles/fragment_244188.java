public class Controller {

        private View view;
        private Model model;

       //constructor will get the view and the model, and adds ActionHandlers
       public Controller(final Model amodel, final View aview) {
               this.view=aview;
               this.model=amodel;
               addOneButtonActionHandler();
               addSecondButtonActionHandler();
        }

       public void addOneButtonActionHandler(){

              ActionListener actionHandler= new ActionListener() {

                      @Override
                      public void actionPerformed(final ActionEvent e) {
                            //some action to get the String from user (?)
                            model.storeItem(string);
                      }
              };

              view.addActionToOneButton(actionHandler);
       }

       public void addSecondButtonActionHandler(){

              ActionListener actionHandler= new ActionListener() {

                      @Override
                      public void actionPerformed(final ActionEvent e) {
                            //some action to get the stored String from Model
                            //String key =model.getStoredItem();
                      }
              };

              view.addActionToSecondButton(actionHandler);
       }

}