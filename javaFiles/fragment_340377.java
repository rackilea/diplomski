calendarTable.addComponentListener(new ComponentAdapter() {
    public void componentResized(ComponentEvent evt) {
        if (evt.getID() == ComponentEvent.COMPONENT_RESIZED) {
            calendarTable.setRowHeight(calendarTable.getHeight() / calendarTable.getRowCount());
        }
    }
});