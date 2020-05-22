public class NumberListCellEditor extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof Integer) {

            int number = (Integer) value;
            if (number < 10) {
                value = "0" + number;
            }

        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }

}