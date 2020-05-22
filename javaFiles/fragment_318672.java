public class MyTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Color getBackground() {
        String steak = getText();
        if (steak.startsWith("+")) {
            return Color.GREEN;
        } else if (steak.startsWith("-")) {
            return Color.RED;
        } else if (steak.startsWith("~")) {
            return Color.YELLOW;
        } else if (steak.equals("")) {
            return Color.WHITE;
        }

            return super.getBackground();
        }
    }
}