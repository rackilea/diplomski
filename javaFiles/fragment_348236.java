public void Menu()
     {

             Image img = ImageIO.read(getClass().getResource("Image1.jpg"));

             JFrame f1=new JFrame("Menu");
             f1.setSize(400,200);

             JPanel P1=new JPanel();
             JButton b1=new JButton("Creamy Chocolate Cup");  
             b1.setIcon(new ImageIcon(img));

             P1.add(b1);
             f1.add(P1);
             f1.setVisible(true);
    }