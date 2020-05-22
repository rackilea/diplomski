public static class XBoxLayout extends BoxLayout {

    enum Strategy {
        NONE,
        STRETCH_LAST,
        DISTRUBUTE
    }

    private Strategy strategy;

    public XBoxLayout(Container target, int axis, Strategy strategy) {
        super(target, axis);
        this.strategy = strategy;
    }


    @Override
    public void layoutContainer(Container target) {
        super.layoutContainer(target);
        if (Strategy.NONE == strategy) return;
        Insets targetInsets = target.getInsets();
        int targetSize = target.getWidth() - targetInsets.left - targetInsets.right;
        int childSum = 0;
        for (Component child : target.getComponents()) {
            childSum += child.getWidth();
        }
        if (targetSize > childSum) {
            int excess = targetSize - childSum;
            distribute(target, excess);
        }
    }


    private void distribute(Container target, int excess) {
        System.out.println("childCount/rounding excess " + target.getComponentCount() + "/" + excess);
        if (Strategy.STRETCH_LAST == strategy) {
            Component lastChild = target.getComponent(target
                    .getComponentCount() - 1);
            lastChild.setSize(lastChild.getWidth() + excess,
                    lastChild.getHeight());
        } else {
            int firstToDistribute = target.getComponentCount() - excess;
            int summedOffset = 0;
            for(int index = firstToDistribute; index < target.getComponentCount(); index++) {
                Component child = target.getComponent(index);
                Rectangle bounds = child.getBounds();
                bounds.x += summedOffset++;
                bounds.width += 1;
                child.setBounds(bounds);
            }
        }
    }

}