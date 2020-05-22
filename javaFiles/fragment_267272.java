Component source = (Component)evt.getSource(); 
    Dimension size = source.getSize(); 

    int xPos = ((size.width - Pmenu.getPreferredSize().width) / 2); 
    int yPos = size.height;

    Pmenu.show(source, xPos, yPos);