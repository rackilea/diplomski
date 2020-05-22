// your code...

tabbedPane.setUI(new MinimalisticTabbedPaneUI());

// your code...

public static class MinimalisticTabbedPaneUI extends BasicTabbedPaneUI {

    // paints the border around the currently visible content
    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        // do nothing
    }

    // paints the border around each tab
    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex, int x, int y, int w, int h, boolean isSelected) {
        // only paints a border if the tab is selected, edit this to add your personal formatting
        if(isSelected){
            super.paintTabBorder(g, tabPlacement, tabIndex, x, y, w, h, isSelected);
        }
    }
}