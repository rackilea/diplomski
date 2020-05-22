//create Rect
    Rect rect = new Rect();
    //set the size of the new panel
    rect.setPreferredSize(new Dimension(800, 600));
    //add the rect to your JFrame
    window.add(rect);
    //now you can change the color for all Rect instances
    //Note how I use Rect instead of rect, however, both will work.
    Rect.myColor = Color.BLUE;
    //And dont forget to repaint it if you want to see the changes immediatly
    rect.repaint();