@Override
public String getToolTipText(MouseEvent event) {
    String tip = null;
    Point p = event.getPoint();

    // Locate the renderer under the event location
    int hitColumnIndex = columnAtPoint(p);
    int hitRowIndex = rowAtPoint(p);

    if (hitColumnIndex != -1 && hitRowIndex != -1) {
        TableCellRenderer renderer = getCellRenderer(hitRowIndex, hitColumnIndex);
        Component component = prepareRenderer(renderer, hitRowIndex, hitColumnIndex);
        Rectangle cellRect = getCellRect(hitRowIndex, hitColumnIndex, false);
        component.setBounds(cellRect);
        component.validate();
        component.doLayout();
        p.translate(-cellRect.x, -cellRect.y);
        Component comp = component.getComponentAt(p);
        if (comp instanceof JComponent) {
            return ((JComponent) comp).getToolTipText();
        }
    }

    // No tip from the renderer get our own tip
    if (tip == null) {
        tip = getToolTipText();
    }

    return tip;
}