class AutoHidingBehavior extends AbstractBehavior {

    @Override
    public void bind(Component component) {
        if (! (component instanceof MarkupContainer) ) {
            throw new IllegalArgumentException("This behavior can only be used with markup containers");
        }
    }

    @Override
    public void onConfigure(Component component) {
        MarkupContainer container = (MarkupContainer) component;
        boolean hasVisibleChildren = false;
        for (Iterator<? extends Component> iter = container.iterator(); iter.hasNext(); ) {
            if ( iter.next().isVisible() ) {
                hasVisibleChildren = true;
                break;
            }
        }
        container.setVisible(hasVisibleChildren);
    }

}