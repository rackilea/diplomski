@Override
public void scrollRectToVisible(Rectangle t){
    // need to adjust scrollbar position
    if (t.getY()<0){
        // scroll up
        JScrollBar scrollBar = getScrollBar();
        scrollBar.setValue(scrollBar.getValue() + (int)(t.getY()));
    }else if (t.getY()+t.getHeight()>getBounds().getHeight()){
        // scroll down
        JScrollBar scrollBar = getScrollBar();
        scrollBar.setValue(scrollBar.getValue() - (int)(getBounds().getHeight()-t.getY()-t.getHeight()));
    }
    doLayout();
    repaint();
}