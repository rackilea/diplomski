private void setCategoryPanel(){
    //set the color label category       

    JPanel panelCategory=new JPanel();      
     panelCategory.setLayout(new FlowLayout(FlowLayout.LEADING));       


    JButton btnCategory1=new JButton("    ");
    Dimension btnCategory_1_Dimension = new Dimension(categoryButtonWidth, categoryHight);
    btnCategory_1.setSize(btnCategory_1_Dimension);
    btnCategory_1.setMaximumSize(btnCategory_1_Dimension);
    btnCategory_1.setMinimumSize(btnCategory_1_Dimension);
    btnCategory_1.setBackground(Color.red);
    btnCategory_1.addActionListener(this);   
    panelCategory.add(btnCategory_1);

    JTextField txtCategory1 = new JTextField(20);
    Dimension txtCategory_1_Dimension = new Dimension (categoryTextFieldWidth, categoryHight);
    txtCategory_1.setSize(txtCategory_1_Dimension);  
    txtCategory_1.setMinimumSize(txtCategory_1_Dimension);
    txtCategory_1.setMaximumSize(txtCategory_1_Dimension);
    panelCategory.add(txtCategory_1);


    JButton btnCategory_2=new JButton("    ");
    Dimension btnCategory_2_Dimension = new Dimension(categoryButtonWidth, categoryHight);
    btnCategory_2.setSize(btnCategory_2_Dimension);
    btnCategory_2.setMaximumSize(btnCategory_2_Dimension);
    btnCategory_2.setMinimumSize(btnCategory_2_Dimension);
    btnCategory_2.setSize(new Dimension ( categoryButtonWidth, categoryHight));      
    btnCategory_2.setBackground(Color.YELLOW);   
    btnCategory_2.addActionListener(this);
    panelCategory.add(btnCategory_2);

    JTextField txtCategory2 = new JTextField(20);
    Dimension txtCategory_2_Dimension = new Dimension (categoryTextFieldWidth, categoryHight);
    txtCategory_2.setSize(txtCategory_1_Dimension);  
    txtCategory_2.setMinimumSize(txtCategory_1_Dimension);
    txtCategory_2.setMaximumSize(txtCategory_1_Dimension);   
    panelCategory.add(txtCategory2);    
    this.add(panelCategory,  BorderLayout.NORTH);
}