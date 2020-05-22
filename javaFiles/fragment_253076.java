public class sampleProg extends JFrame {
    JPanel background = new JPanel() {
        public void paint (Graphics g){
            g.drawImage(img,0,0,getSize().width,getSize().height,this);
            super.paint(g);
        }
    };

    public sampleProg(string str) {
        //...

        ImageIcon icon = new ImageIcon("bg.jpg");
        img=icon.getImage();

        //...

        Color transparent = new Color(0, true);
        background.setBackground(transparent);
    }
}