public void draw() {

        System.out.println("draw started");         //To check that the method is getting invoked.

        setTitle("Sight Words Rock");

        WindowListener l = new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
           System.exit(0);
         }
      };
        addWindowListener(l);

        pack();
        setVisible(true);
    System.out.println("draw done");        //To check that the whole method went through. It's all working.

}