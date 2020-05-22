public static class FixedFlowLayout extends FlowLayout {

    /**
     * C&p mostly - RToL border fix implemented.
     */
    protected int moveComponents(Container target, int x, int y, int width,
            int height, int rowStart, int rowEnd, boolean ltr,
            boolean useBaseline, int[] ascent, int[] descent) {
        switch (getAlignment()) {
        case LEFT:
            x += ltr ? 0 : width;
            break;
        case CENTER:
            x += width / 2;
            break;
        case RIGHT:
            x += ltr ? width : 0;
            break;
        case LEADING:
            break;
        case TRAILING:
            x += width;
            break;
        }
        int maxAscent = 0;
        int nonbaselineHeight = 0;
        int baselineOffset = 0;
        if (useBaseline) {
            int maxDescent = 0;
            for (int i = rowStart; i < rowEnd; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    if (ascent[i] >= 0) {
                        maxAscent = Math.max(maxAscent, ascent[i]);
                        maxDescent = Math.max(maxDescent, descent[i]);
                    } else {
                        nonbaselineHeight = Math.max(m.getHeight(),
                                nonbaselineHeight);
                    }
                }
            }
            height = Math.max(maxAscent + maxDescent, nonbaselineHeight);
            baselineOffset = (height - maxAscent - maxDescent) / 2;
        }

        int right = target.getWidth() - target.getInsets().right - getHgap();

        for (int i = rowStart; i < rowEnd; i++) {
            Component m = target.getComponent(i);
            if (m.isVisible()) {
                int cy;
                if (useBaseline && ascent[i] >= 0) {
                    cy = y + baselineOffset + maxAscent - ascent[i];
                } else {
                    cy = y + (height - m.getHeight()) / 2;
                }
                if (ltr) {
                    m.setLocation(x, cy);
                    x += m.getWidth() + getHgap();
                } else {
                    m.setLocation(right - m.getWidth(), cy);
                    right -= m.getWidth() + getHgap();
                }
            }
        }
        return height;
    }

    /**
     * C&p, to be able to call the fixed moveComponent.
     */
    @Override
    public void layoutContainer(Container target) {
        synchronized (target.getTreeLock()) {
            Insets insets = target.getInsets();
            int maxwidth = target.getWidth()
                    - (insets.left + insets.right + getHgap() * 2);
            int nmembers = target.getComponentCount();
            int x = 0, y = insets.top + getVgap();
            int rowh = 0, start = 0;

            boolean ltr = target.getComponentOrientation().isLeftToRight();

            boolean useBaseline = getAlignOnBaseline();
            int[] ascent = null;
            int[] descent = null;

            if (useBaseline) {
                ascent = new int[nmembers];
                descent = new int[nmembers];
            }

            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    Dimension d = m.getPreferredSize();
                    m.setSize(d.width, d.height);

                    if (useBaseline) {
                        int baseline = m.getBaseline(d.width, d.height);
                        if (baseline >= 0) {
                            ascent[i] = baseline;
                            descent[i] = d.height - baseline;
                        } else {
                            ascent[i] = -1;
                        }
                    }
                    if ((x == 0) || ((x + d.width) <= maxwidth)) {
                        if (x > 0) {
                            x += getHgap();
                        }
                        x += d.width;
                        rowh = Math.max(rowh, d.height);
                    } else {
                        rowh = moveComponents(target, insets.left + getHgap(),
                                y, maxwidth - x, rowh, start, i, ltr,
                                useBaseline, ascent, descent);
                        x = d.width;
                        y += getVgap() + rowh;
                        rowh = d.height;
                        start = i;
                    }
                }
            }
            moveComponents(target, insets.left + getHgap(), y, maxwidth - x,
                    rowh, start, nmembers, ltr, useBaseline, ascent,
                    descent);
        }
    }

    public FixedFlowLayout() {
    }

    public FixedFlowLayout(int align, int hgap, int vgap) {
        super(align, hgap, vgap);
    }

    public FixedFlowLayout(int align) {
        super(align);
    }

}