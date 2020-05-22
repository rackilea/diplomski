@SuppressWarnings("serial")
class LabelButton extends JLabel {
    private static final int PREF_W = 160;
    private static final int PREF_H = 40;
    private static final Color NON_EDIT_BG = new Color(210, 210, 210);
    private static final Color EDIT_BG = new Color(160, 160, 160);
    private static final Color EDIT_RECT_COLOR = new Color(210, 210, 210);
    private static final Color NON_EDIT_RECT_COLOR = new Color(140, 140, 140);
    private static final Color TEXT_COLOR = new Color(40, 40, 40);
    public static final String EDITING_TEXT = "...";
    private boolean editMode = false;

    public LabelButton() {
        this("");
    }

    public LabelButton(String text) {
        super(text);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalTextPosition(JLabel.CENTER);
        addMouseListener(new MyMouse());
        addKeyListener(new MyKey());
        setFocusable(true);
        setOpaque(true);
        setBackground(NON_EDIT_BG);
        setForeground(TEXT_COLOR);
        setBorder(BorderFactory.createLineBorder(NON_EDIT_RECT_COLOR));
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension superSz = super.getPreferredSize();
        if (isPreferredSizeSet()) {
            return superSz;
        }
        int prefW = Math.max(superSz.width, PREF_W);
        int prefH = Math.max(superSz.height, PREF_H);
        return new Dimension(prefW, prefH);
    }

    public void setEditMode(boolean editMode) {
        this.editMode = editMode;
        Color bg = editMode ? EDIT_BG : NON_EDIT_BG;
        Color rectColor = editMode ? EDIT_RECT_COLOR : NON_EDIT_RECT_COLOR;
        String drawText = editMode ? "..." : getText();

        setBackground(bg);
        setBorder(BorderFactory.createLineBorder(rectColor));
        setText(drawText);

        if (editMode) {
            requestFocusInWindow();
        }
    }

    public boolean isEditMode() {
        return editMode;
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 1) {
                setEditMode(!isEditMode());
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setEditMode(false);
        }
    }

    private class MyKey extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (editMode) {
                String text = (String.valueOf(e.getKeyChar()).toUpperCase());
                setText(text);
                setEditMode(false);
            }
        }
    }
}