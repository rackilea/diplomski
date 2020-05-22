public static class TestTable extends JTable {
    static final int THRESHOLD = 10;
    static String[] columns = {"name", "description", "other"};
    static String[][] data = {
            {"name1", "some description 1", "other value we don't care about"},
            {"name2", "some description 2", "other value we don't care about"},
            {"name3", "some description 3", "other value we don't care about"}
    };

    public TestTable() {
        super(data, columns);
        setAutoResizeMode(AUTO_RESIZE_OFF);
        setAutoscrolls(false);

        getColumnModel().getColumn(0).setPreferredWidth(300);
        getColumnModel().getColumn(1).setPreferredWidth(300);
        getColumnModel().getColumn(2).setPreferredWidth(300);
    }

    @Override
    public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend) {
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
        scrollColumnToVisible(rowIndex, columnIndex);
    }

    private void scrollColumnToVisible(int rowIndex, int columnIndex) {
        Rectangle cellRect = getCellRect(rowIndex, columnIndex, false);

        int leftX = cellRect.x;
        int rightX = cellRect.x + cellRect.width;

        //assuming we're in scroll pane
        int width = Math.min(getWidth(), getParent().getWidth());

        int scrolledX = -getX();
        int visibleLeft = scrolledX;
        int visibleRight = visibleLeft + width;

        //bonus, scroll if only a little of a column is visible
        visibleLeft += THRESHOLD;
        visibleRight -= THRESHOLD;

        boolean isCellVisible = leftX < visibleRight // otherwise cell is hidden on the right
                && rightX > visibleLeft // otherwise cell is hidden on the left
                ;
        if (!isCellVisible) {
            scrollRectToVisible(cellRect);
        }
    }
}