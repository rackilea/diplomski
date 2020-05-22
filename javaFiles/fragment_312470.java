// button action listener code

 Thread t = new Thread(new Runnable() {
    public void run() {

       // execute query here

       SwingUtilities.invokeLater(new Runnable() {
           public void run() {

               // update the ui here

           }
       });
    }
 });
 t.start();