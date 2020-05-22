public class CloseIcon extends JPanel {

    private static final Dimension CROSS_ICON_SIZE = new Dimension(15, 15);
    private static final int CROSS_ICON_INSET = 5;
    private boolean mouseInTheHouse = false;

    public CloseIcon() {
        setOpaque(false);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                fireActionPerformed();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseInTheHouse = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseInTheHouse = false;
            }

        });
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    protected void fireActionPerformed() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners.length > 0) {
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "Closed");
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }
    }

    //You don't have to override the getSize() versions. It basically calls getWidth() and getHeight()
    //Also you should NOT override getWidth() and getHeight() because the layout managers set that properties
    //If you do the borders right/bottom edges won't be painted correctly
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(CROSS_ICON_SIZE.width + CROSS_ICON_INSET, CROSS_ICON_SIZE.height);
    }

    @Override
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return getPreferredSize();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gfx = (Graphics2D) g.create();

        int componentWidth = getWidth();
        int ovalRadius = (int) (CROSS_ICON_SIZE.getWidth());
        Insets insets = getInsets();
        Point gfxXlatePoint = new Point(componentWidth - (int) CROSS_ICON_SIZE.getWidth() - insets.right, insets.top);
        Rectangle paintRectangle = new Rectangle(gfxXlatePoint, CROSS_ICON_SIZE);
        gfx.translate(gfxXlatePoint.x, gfxXlatePoint.y);

        gfx.setStroke(new BasicStroke(2));
        gfx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Insets crossIconPadding = new Insets(5, 5, 5, 5);
        if (mouseInTheHouse) {
            gfx.setColor(new Color(0xf49f94));
            //The mouse pointer is on the x mark
            gfx.fillOval(0, 0, ovalRadius, ovalRadius);
            gfx.setColor(Color.WHITE);
            gfx.drawLine(0 + crossIconPadding.left, 0 + crossIconPadding.top, (int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
            gfx.drawLine((int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, 0 + crossIconPadding.top, 0 + crossIconPadding.left, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
        } else {
            gfx.setColor(Color.BLACK);
            gfx.drawLine(0 + crossIconPadding.left, 0 + crossIconPadding.top, (int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
            gfx.drawLine((int) CROSS_ICON_SIZE.getWidth() - crossIconPadding.right, 0 + crossIconPadding.top, 0 + crossIconPadding.left, (int) CROSS_ICON_SIZE.getHeight() - crossIconPadding.bottom);
        }
        gfx.dispose();
    }

}