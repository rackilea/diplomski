class Mover{
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {     // Run the GUI codes on the EDT
            @Override
            public void run() {
                JFrame frame = new JFrame("Some Basic Animation");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new DrawingSpace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);             
            }
        }); 
    }
}