public  HelloWorld()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hello World Button App");

          panel pan= new panel();
         add(pan);
         pack();
         setVisible(true);
    }
   }

   class panel extends JPanel {

      private JButton btn1 = new JButton("Klick!");
      private JTextField txt1 = new JTextField(10);
      private JTextField txt2 = new JTextField(10);

      public panel() {

           add(btn1);
           add(txt1);
           add(txt2);
        }
      }