class KnightRunner
{   
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("Knight Runner");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
                frame.add(new DrawingSpace());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);             
            }
        });
    }       
}