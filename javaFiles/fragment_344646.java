public class ImageButton extends JButton{
    private String problem;
    private BufferedImage image;
    private Boolean status;//true -> image, false -> problem, null -> answered

    public ImageButton(String problem, BufferedImage image, int x, int y, int width, int height){
        this.image = image.subImage(x,y,width,height);
        this.problem = problem;
        this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.addActionListener(new DefaultListener());
        this.status = true;
    }

    public void action(){
        if(status == true){
            status = false;
        }
    }

    public void answer(){
        if(status == false){
            status = null;
        }
    }

    public void paintComponent(Graphics g){
        if(status == null){
            // TODO what will happen after it is answered
        }else{
            g.drawImage(image, 0, 0, this);
            if(!status){
                printString(g, problem, 10);
            }
        }
    }

    public static void printString(Graphics g, String string, int height) {
        if (string != null) {
            int width = g.getFontMetrics().stringWidth(string);
            int length = string.length();
            if (width > getWidth() - 40) {
                length = cutString(g, string);
                g.drawString(string.substring(0, length), 20, height);
                printString(g, string.substring(length), height + 35);
            }
            g.drawString(string.substring(0, length), 20, height);
        }
    }

    public static int cutString(Graphics g, String string) {
        int count = 1;
        int space = 0;
        while (g.getFontMetrics().stringWidth(string.substring(0, count)) < getWidth() - 40) {
            if (string.charAt(count) == 32) {
                space = count;
            }
            count++;
        }
        return space;
    }
}