class MyClass extends JPanel
   {

        void doStuff()
        {
        }

        boolean someLogic()
        {
           return 1>2;
        }

        void setupUI() 
        {
            addMouseListener(new MouseAdapter() {
               @Override
               public void mouseClicked(MouseEvent e) {
                 if (e.getClickCount() == 2 && someLogic())
                   doStuff();
               }
            });                                
        }
    }