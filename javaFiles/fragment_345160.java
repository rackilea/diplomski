public JPanelInformations() {
    //JPanel PanelInformation = new JPanel(); remove new instance of panel
    setLayout(new GridLayout(7,1,5,5)); 

    JLabel labelInfo = new JLabel ("INFORMATION");
    JLabel labelPrix = new JLabel ("Prix");
    JLabel labelDesc = new JLabel ("Description");    
    JLabel labelQuant = new JLabel ("Quantite");    
    JTextField fieldPrix = new JTextField (20); 
    JTextArea fieldDesc = new JTextArea (20, 20); 
    JTextField fieldQuantite = new JTextField (20); 

    add(labelInfo); //remove PanelInformation.
    add(labelPrix);//remove PanelInformation.
    add(fieldPrix);//remove PanelInformation.
    add(labelDesc);//remove PanelInformation.
    add(fieldDesc);//remove PanelInformation.
    add(labelQuant);//remove PanelInformation.
    add(fieldQuantite);//remove PanelInformation.
}