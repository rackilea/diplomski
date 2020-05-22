private void scrollBarMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {                                          
        if (evt.getUnitsToScroll() > 0) {
            scrollBar.setValue(scrollBar.getValue() + 1);
        } else {
            scrollBar.setValue(scrollBar.getValue() - 1);
        }
   }