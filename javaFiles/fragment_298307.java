public class AddMoreLablesToFrame{  

  private static void main(String args []){
        JFrame frame = new JFrame();

        frame.setLayout(new FlowLayout()); // <-- you need this for now

         for(int i=0;i<80;i++){
           JLabel label   =  new JLabel("Label" +i);
           frame.add(label);
         }


        frame.setVisible(true);

        // optional, but nice to have.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
}
For more: Creating a GUI With JFC/Swing