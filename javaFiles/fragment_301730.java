public void ok(ActionEvent event){
    final Runnable update = new Runnable() {
       @Override 
       public void run() {
         count+=0.1;
         label.setText(count+"");
        }
    };

   ActionListener delayedAction = new ActionListener(){
     @Override
     public void actionPerformed(java.awt.event.ActionEvent arg0) {
       Platform.runLater(update);
     }
   };

   new Timer(1000, delayedAction).start();
}

    Platform.runLater(update);
}