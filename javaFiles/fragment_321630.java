public class Core extends JPanel{
    public static void main(String[] args){
        //..
        pane.setLayout(new GridLayout(number, number));
        for(int j = 1; j <= number; j++){
            Color backColor = Color.white;
            Image  image = new ImageIcon((images.get(j)) + ".jpg").getImage();
            // This be bad...
            //public paintComponent(Graphics g){//error here(paintComponent cannot be resolved to a variable)(Illegal modifier for 'g')
            //    super.paintComponent(Graphics g);//and error here (cannot use super)(Graphics cannot be resokved to a variable)
            //
            //g.drawImage(image, 0, 0, 100, 100, null);}
            ColorPanel panelz = new ColorPanel(backColor);
            pane.add(panelz);
        }


        theGUI.setVisible(true);
        //...
    }

    // This be better...
    @Override   
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the List of images here how ever you want...
    }

}