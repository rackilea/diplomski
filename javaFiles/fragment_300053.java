public String getToolTipText(MouseEvent event) {
    if(event != null) {
        Point p = event.getPoint();
        int index = locationToIndex(p);
        ListCellRenderer<? super E> r = getCellRenderer();
        Rectangle cellBounds;

        if (index != -1 && r != null && (cellBounds =
                           getCellBounds(index, index)) != null &&
                           cellBounds.contains(p.x, p.y)) {
            ListSelectionModel lsm = getSelectionModel();
            Component rComponent = r.getListCellRendererComponent(
                       this, getModel().getElementAt(index), index,
                       lsm.isSelectedIndex(index),
                       (hasFocus() && (lsm.getLeadSelectionIndex() ==
                                       index)));

            if(rComponent instanceof JComponent) {
                MouseEvent      newEvent;

                p.translate(-cellBounds.x, -cellBounds.y);
                newEvent = new MouseEvent(rComponent, event.getID(),
                                          event.getWhen(),
                                          event.getModifiers(),
                                          p.x, p.y,
                                          event.getXOnScreen(),
                                          event.getYOnScreen(),
                                          event.getClickCount(),
                                          event.isPopupTrigger(),
                                          MouseEvent.NOBUTTON);

                String tip = ((JComponent)rComponent).getToolTipText(
                                          newEvent);

                if (tip != null) {
                    return tip;
                }
            }
        }
    }
    return super.getToolTipText();
}