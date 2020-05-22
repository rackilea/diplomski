public static void main(String[] args) {
    JFrame frame =  new JFrame();
    frame.setContentPane(new CostumTable());
    frame.getContentPane().addMouseListener(new MouseListener() {

        @Override
        public void mouseClicked(MouseEvent e) {

            Component clicked = frame.getContentPane().getComponentAt(e.getPoint());
            if(clicked instanceof JLabel){
                JLabel myLabel = (JLabel) clicked;
                //obviously myLabel is the clicked JLabel
                System.out.println("Text of clicked Label: " + myLabel.getText());
            }

        }
        @Override
        public void mousePressed(MouseEvent e) {

        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {

        }
        @Override
        public void mouseExited(MouseEvent e) {

        }

    });

    frame.setSize(200, 500);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setVisible(true);
}