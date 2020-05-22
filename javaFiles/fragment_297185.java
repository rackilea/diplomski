public class JXToolBar extends JToolBar {

         public JButton add(Action action) {
              JButton button = super.add(action);
              KeyStroke stroke = (KeyStroke) action.getValue(Action.ACCELERATOR_KEY);
              if (stroke != null) {
                  // do the input/actionMap config here
              }
         }
    }