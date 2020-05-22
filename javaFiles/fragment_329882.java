public class Main exends JFrame{
    MyPanel panel;
    private BufferedImage img;

    public Main(){
        try {
            img = ImageIO.read(new File("C:\\Users\\Ryan T\\Desktop\\wNSE6p7.jpg"));
        } catch(IOException e) {
            e.printStackTrace();
        }
        panel= new MyPanel();
        add(panel);
    }    

    private class MyPanel extends JPanel{
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}