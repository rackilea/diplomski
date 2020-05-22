if(this.icon!=null){
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int x = (dummyInsets==null) ? 0 : dummyInsets.left - 5;
        textX = x+iconWidth+2;
        int y = (this.getHeight() - iconHeight)/2;
        icon.paintIcon(this, g, x, y);
    }