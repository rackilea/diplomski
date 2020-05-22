class ButtonToggleRunner{
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){         
            @Override
            public void run(){      
                JFrame f = new JFrame("Toggle Colors");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.add(new DrawingSpace());
                f.pack();   
                f.setLocationRelativeTo(null);
                f.setVisible(true);             
            }
        });             
    }
}