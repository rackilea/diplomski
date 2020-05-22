public JPanelVentes() {
    //JPanel PanelVentes = new JPanel(); remove the new instance of JPanel
    setLayout(new GridLayout());
    JLabel labelVendre = new JLabel ("VENDRE");
    JLabel labelQte = new JLabel ("Quantite");
    JLabel labelPromo = new JLabel ("Promotion");
    JLabel labelTot = new JLabel ("Total");    
    JTextField fieldQte = new JTextField (20); 
    JTextField fieldPromoEuros = new JTextField (20); 
    JTextField fieldPromoPourcent = new JTextField (20); 
    JTextField fieldTotal = new JTextField (20); 


    add (labelVendre); //remove PanelVentes
    add (labelQte);//remove PanelVentes
    add (fieldQte);//remove PanelVentes
    add (labelPromo);//remove PanelVentes
    add (fieldPromoEuros);//remove PanelVentes
    add (fieldPromoPourcent);//remove PanelVentes
    add (labelTot);//remove PanelVentes
    add (fieldTotal);//remove PanelVentes
}