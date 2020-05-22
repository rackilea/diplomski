public void processView(SecondaryProcessPanel secondary){
    this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
    for (int i = 0; i < this.docList.size(); i++){
        System.out.println("i = " + i);
        JScrollPane imageHolder = new JScrollPane();

        JScrollPane panelBack = secondary.getPanel(this.docList.get(i), imageHolder);
        panelBack.setPreferredSize(new Dimension(800,800));
        this.add(panelBack, i);
    }


    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(600, 800);
    this.pack();

}

public JScrollPane getPanel(BufferedImage image, JScrollPane imageHolder){

    this.image = image;
    imageHolder = new JScrollPane(this);    

    return imageHolder;
}