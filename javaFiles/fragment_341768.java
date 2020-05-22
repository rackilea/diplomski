public static class SuperAwesomeBetterThenYoursLayout implements LayoutManager {

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(100, 300);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(100, 300);
    }

    @Override
    public void layoutContainer(Container parent) {
        boolean laidOut = false;
        for (Component child : parent.getComponents()) {
            if (child.isVisible() && !laidOut) {
                child.setLocation(200, 100);
                child.setSize(child.getPreferredSize());
            } else {
                child.setSize(0, 0);
            }
        }
    }

}