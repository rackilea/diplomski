public class FreezePane extends JComponent {
    public FreezePane() {
        // trap mouse, key, and focus events
        addMouseListener( new MouseAdapter() );
        addMouseMotionListener( new MouseMotionAdapter() );
        addKeyListener( new KeyAdapter() );
        addFocusListener( new FocusListener() {
            // do not let any component take focus while visible
            public void focusLost(FocusEvent e) {
                requestFocusInWindow();
            }
            public void focusGained(FocusEvent e) {}
        }
    }
}