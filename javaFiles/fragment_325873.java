abstract class ActionWithCleanup extend AbstractAction {
       @Override
       public final void actionPerformed(ActionEvent arg0) {
            myAction();
            cleanup(); // has to be done after every menu operation
       }

       public abstract void myAction();
}