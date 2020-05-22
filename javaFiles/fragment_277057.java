public class EvenOddRenderer implements TableCellRenderer {

        public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            DEFAULT_RENDERER.setHorizontalAlignment(JLabel.CENTER);
            Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                    table, value, isSelected, hasFocus, row, column);
            ((JLabel) renderer).setOpaque(true);
            Color foreground, background;
            Color alternate = new Color(0xC0, 0xC0, 0xF0);
            Color lightBlue = new Color(204, 204, 255);

            if (isSelected) {
                foreground = Color.black;
                background = Color.gray;
            } else {
                if (row % 2 == 0) {
                    foreground = Color.black;
                    background = Color.white;
                } else {
                    foreground = Color.black;
                    background = lightBlue;
                }
            }
            renderer.setForeground(foreground);
            renderer.setBackground(background);
            return renderer;
        }
    }