public class Outer extends JFrame{
      private JTextField text = new JTextField();
      ...

      public Outer(){
        this.add(new Inner1(), BorderLayout.NORTH);
        this.add(new Inner2(), BorderLayout.SOUTH);
      }

      class Inner1 extends JPanel{
        ...
         public Inner1(){
            this.add(text);
         }  
      }

      class Inner2 extends JPanel implements ActionListener{
             private JButton button = new JButton();

             public Inner2(){
                button.addActionListener(this);
             }

        public void actionPerformed(ActionEvent e){
            if (e.getSource() == button)
                text.setText("Hello StackOverFlow");
        } 
      }
}