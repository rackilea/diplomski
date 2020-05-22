//After initializing the imgPanel

imgPanel.setLayout(null); //explicitly declare the imgPanel layout to null

JLabel lbl = new JLabel("STD");
imgPanel.add(lbl)

Insets imgPanelInsets = imgPanel.getInsets(); //define the components insets
Dimension sizeImg = lbl.getPreferredSize(); //define the components dimension
lbl.setBounds(100 + imgPanelInsets.left, 5 + imgPanelInsets.top,
             sizeImg.width + 5, sizeImg.height + 5);  

JLabel lbl2 = new JLabel("AIRLINE");
imgPanel.add(lbl2)

sizeImg = lbl2.getPreferredSize();
lbl2.setBounds(100 + imgPanelInsets.left, 5 + imgPanelInsets.top,
             sizeImg.width + 5, sizeImg.height + 5);