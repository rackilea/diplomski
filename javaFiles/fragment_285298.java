public class ExtendedTabbedPaneUI extends BasicTabbedPaneUI {

    @Override
    protected JButton createScrollButton(int direction) {
         if (direction != SOUTH && direction != NORTH && direction != EAST &&
                                   direction != WEST) {
             throw new IllegalArgumentException("Direction must be one of: " +
                                                "SOUTH, NORTH, EAST or WEST");
         }

         //return new ScrollableTabButton(direction);

         return new BasicArrowButton(direction,
            UIManager.getColor("TabbedPane.selected"),
            UIManager.getColor("TabbedPane.shadow"),
            UIManager.getColor("TabbedPane.darkShadow"),
            UIManager.getColor("TabbedPane.highlight")) {

            @Override
            public Dimension getPreferredSize() {
                int maxWidth = calculateMaxTabWidth(JTabbedPane.LEFT);
                return new Dimension(maxWidth, super.getPreferredSize().height);
            }
        };
    }
}