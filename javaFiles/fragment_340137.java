public final class CenterComponentsDemo {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();                 
            }
        });
    }

    private static void createAndShowGUI(){
        final JFrame frame = new JFrame("Center Components Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ButtonPane());
        frame.setSize(new Dimension(300, 100)); // Done for demo
        //frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static class ButtonPane extends JPanel{
        public ButtonPane(){
            super();
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            setBackground(Color.PINK);
            final JButton button = new JButton("Start");
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            add(Box.createVerticalGlue());
            add(button);
            add(Box.createVerticalGlue());
        }
    }
}