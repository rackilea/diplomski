public static void main(String args[]) { 
    SwingUtilities.invokeLater( new Runnable() {
         void run() 
         {
             JFrame z = new JFrame();
             z.add(new X()); // works only in java 6
            //z.getContentPane().add(new X()); // works in any version of java
             z.pack(); // assuming your pane has preferred size 
             z.setVisible(true); 

         }
    }); 
}