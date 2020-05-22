private static class CustomJPanel extends JPanel {
    private static final long serialVersionUID = 6859593162185621113L;
    private final int current;

    private CustomJPanel(int current) {
        this.current = current;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        switch(current){
            case 1:
                System.out.println("case 1");
                //g.drawImage(image1, 10, 10, getWidth() - 20, getHeight() - 20, this);
                break;
            case 2:
                System.out.println("case 2");
                // g.drawImage(image2, 20, 20, getWidth() - 40, getHeight() - 40, this);
                break;
            case 3:
                System.out.println("case 3");
                //g.drawImage(image3, 10, 10, getWidth() - 20, getHeight() - 20, this);
                break;
            case 4:
                System.out.println("case 4");
                //g.drawImage(image4, 10, 10, getWidth() - 20, getHeight() - 20, this);
                break;
            default:
                System.out.println("RELEASE THE KRAKEN!");
                break;
        }// switch
    }// paintComponent()
}