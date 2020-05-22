class SaveImageRunner{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                JFrame frame = new JFrame("Saving a buffered image");
                DrawingSpace ds = new DrawingSpace();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(ds);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                ds.saveBufferAsImage("BlueCircle.png");
            }           
        });
    }
}