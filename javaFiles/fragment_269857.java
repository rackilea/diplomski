public class SO2 {
  public static void main(String[] args) {
    try {
        //Step 1, read in image using javax.ImageIO
        BufferedImage img = ImageIO.read(new File("D:/Users/user/Desktop/Tree.jpeg"));

        //Optional, if you want to resize image this is an effective way of doing it
        Image scaled = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH); 

        //Step 2 create frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Step 3 add image to Frame
        frame.add(new JLabel(new ImageIcon(scaled)));

        //Step 4 Pack frame which sizes it around it's contents, then Show
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}