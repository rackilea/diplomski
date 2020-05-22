public class imagemove extends Component {
    private int x;
    private int y;


    BufferedImage img;

    public imagemove() {
       try {
           img = ImageIO.read(new File("F:/JAVA/workspace/Tutorials/src/imagemove/1.jpg"));
       } catch (IOException e) {
       } 

       x = 0;
       y = 50;
    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(img, x, y, this);
        if (x > 1000) {
            x = 0;
        } else {
            x += 100;
        }   

    if(y > 100) {
        y -= 100;
    } else {
        y += 25;
    }
}


public static void main(String[] args) { 
    JFrame f = new JFrame("Boot");   
    f.setSize(1000,1000);
    f.add(new imagemove());        
    f.setVisible(true);

    for (int number = 1; number <= 15; number++) {
        f.repaint();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}