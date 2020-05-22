class NewJFrame{

   JFrame mainFrame;
   String text;
   JLabel l1;
   JTextField tb1;
   public NewJFrame(String t){

          text=t;
          mainFrame=new JFrame("STRING");
          mainFrame.setSize(800,800);

          // *** must init tb1!!! ***///
          JTextField tb1 = new JTextField();

          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          l1=new JLabel("Entered string");
          tb1.setText(text);
          mainFrame.add(l1);
          mainFrame.add(tb1);
          mainFrame.setVisible(true);
   }
}