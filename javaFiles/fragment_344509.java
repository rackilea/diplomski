public class KeyValueLayout implements LayoutManager {

    public static enum KeyAlignment {
        LEFT, RIGHT;
    }

    private KeyAlignment keyAlignment = KeyAlignment.LEFT;

    private int hgap;

    private int vgap;

    public KeyValueLayout () {
        this(KeyAlignment.LEFT);
    }

    public KeyValueLayout (KeyAlignment keyAlignment) {
        this(keyAlignment, 5, 5);
    }

    public KeyValueLayout (int hgap, int vgap) {
        this(KeyAlignment.LEFT, hgap, vgap);
    }

    public KeyValueLayout (KeyAlignment keyAlignment, int hgap, int vgap) {

        this.keyAlignment = keyAlignment != null ? keyAlignment : KeyAlignment.LEFT;
        this.hgap = hgap;
        this.vgap = vgap;
    }

    public void addLayoutComponent (String name, Component comp) {
    }

    public void addLayoutComponent (Component comp, Object constraints) {
    }

    public void removeLayoutComponent (Component comp) {
    }

    public void layoutContainer (Container parent) {
        Rectangle canvas = getLayoutCanvas(parent);
        int ypos = canvas.y;
        int preferredKeyWidth = getPreferredKeyWidth(parent);

        for (Iterator<Component> iter = new ComponentIterator(parent); iter.hasNext();) {
            Component key = (Component) iter.next();
            Component value = iter.hasNext() ? (Component) iter.next() : null;
            int xpos = canvas.x;
            int preferredHeight = Math.max(key.getPreferredSize().height, value != null ? value.getPreferredSize().height : 0);

            if (keyAlignment == KeyAlignment.LEFT)
                key.setBounds(xpos, ypos, key.getPreferredSize().width, key.getPreferredSize().height);
            else
                key.setBounds(xpos + preferredKeyWidth - key.getPreferredSize().width, ypos, key.getPreferredSize().width,
                    key.getPreferredSize().height);

            xpos += preferredKeyWidth + hgap;
            if (value != null)
                value.setBounds(xpos, ypos, canvas.x + canvas.width - xpos, preferredHeight);
            ypos += preferredHeight + vgap;
        }
    }

    public Dimension minimumLayoutSize (Container parent) {
        int preferredKeyWidth = getPreferredKeyWidth(parent);
        int minimumValueWidth = 0;
        int minimumHeight = 0;
        int lines = 0;
        for (Iterator<Component> iter = new ComponentIterator(parent); iter.hasNext();) {
            lines++;
            Component key = (Component) iter.next();
            Component value = iter.hasNext() ? (Component) iter.next() : null;
            minimumHeight += Math.max(key.getPreferredSize().height, value != null ? value.getMinimumSize().height : 0);
            minimumValueWidth = Math.max(minimumValueWidth, value != null ? value.getMinimumSize().width : 0);
        }

        Insets insets = parent.getInsets();
        int minimumWidth = insets.left + preferredKeyWidth + hgap + minimumValueWidth + insets.right;
        minimumHeight += insets.top + insets.bottom;
        if (lines > 0)
            minimumHeight += (lines - 1) * vgap;

        return new Dimension(minimumWidth, minimumHeight);
    }

    public Dimension preferredLayoutSize (Container parent) {
        int preferredKeyWidth = getPreferredKeyWidth(parent);
        int preferredValueWidth = 0;
        int preferredHeight = 0;
        int lines = 0;
        for (Iterator<Component> iter = new ComponentIterator(parent); iter.hasNext();) {
            lines++;
            Component key = (Component) iter.next();
            Component value = iter.hasNext() ? (Component) iter.next() : null;

            preferredHeight += Math.max(key.getPreferredSize().height, value != null ? value.getPreferredSize().height : 0);
            preferredValueWidth = Math.max(preferredValueWidth, value != null ? value.getPreferredSize().width : 0);
        }

        Insets insets = parent.getInsets();
        int preferredWidth = insets.left + preferredKeyWidth + hgap + preferredValueWidth + insets.right;
        preferredHeight += insets.top + insets.bottom;
        if (lines > 0)
            preferredHeight += (lines - 1) * vgap;

        return new Dimension(preferredWidth, preferredHeight);
    }

    public Dimension maximumLayoutSize (Container target) {
        return preferredLayoutSize(target);
    }

    private int getPreferredKeyWidth (Container parent) {
        int preferredWidth = 0;
        for (Iterator<Component> iter = new ComponentIterator(parent); iter.hasNext();) {
            Component key = (Component) iter.next();
            if (iter.hasNext())
                iter.next();

            preferredWidth = Math.max(preferredWidth, key.getPreferredSize().width);
        }

        return preferredWidth;
    }

    private Rectangle getLayoutCanvas (Container parent) {
        Insets insets = parent.getInsets();
        int x = insets.left;
        int y = insets.top;

        int width = parent.getSize().width - insets.left - insets.right;
        int height = parent.getSize().height - insets.top - insets.bottom;

        return new Rectangle(x, y, width, height);
    }

    private class ComponentIterator implements Iterator<Component> {

        private Container container;

        private int index = 0;

        public ComponentIterator (Container container) {
            this.container = container;
        }

        public boolean hasNext () {
            return index < container.getComponentCount();
        }

        public Component next () {
            return container.getComponent(index++);
        }

        public void remove () {
        }
    }
}