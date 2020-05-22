public class TableHeaderRenderer extends JComponent implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {

                // returns component used for default header rendering
                // makes it independent on current L&F

        return table.getTableHeader().getDefaultRenderer().
                          getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        }

        // following methods are overriden for performance reasons

        @Override
        public void validate() {}

        @Override
        public void revalidate() {}

        @Override
        public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {}

        @Override
        public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {}

}