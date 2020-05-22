JLabel question = new JLabel(" \t \t L'image qu'on peux utiliser pour présenter ce mot est : ");
JPanel pan = new JPanel()
{
        protected void paintComponent(Graphics g) 
        {
            super.paintComponent(g);

            ImageIcon m = new ImageIcon("1.jpg");
            Image monImage = m.getImage();
            g.drawImage(monImage, 0, 0,this);

        }
};
pane.setLayout(new BorderLayout());
pane.add(question, BorderLayout.NORTH);
this.getContentPane().add(pan);