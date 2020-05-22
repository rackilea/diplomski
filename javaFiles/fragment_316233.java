@SuppressWarnings("serial")
public class GlassPane extends JComponent implements KeyListener {

    private static Cursor WAIT_CURSOR = Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR);

    private JXBusyLabel wheel;

    public GlassPane()  {
        super.setOpaque( false );
        super.setLayout( new GridBagLayout() );
        super.setBackground(initBackground());
        initWheel();
        addEventCatchers();
    }

    private void addEventCatchers() {
        addMouseListener( new MouseAdapter() {} );
        addMouseMotionListener( new MouseMotionAdapter() {} );
        addKeyListener(this);
        setFocusTraversalKeysEnabled(false);        
    }

    private Color initBackground() {
        Color base = UIManager.getColor("inactiveCaptionBorder");
        Color background = new Color(base.getRed(), base.getGreen(), base.getBlue(), 128);
        return background;
    }

    private void initWheel() {
        wheel = new JXBusyLabel();
        add(wheel, new GridBagConstraints());
    }

    /*
     *  The component is transparent but we want to paint the background
     *  to give it the disabled look.
     */
    @Override
    protected void paintComponent(Graphics g)   {
        g.setColor( getBackground() );
        g.fillRect(0, 0, getSize().width, getSize().height);
    }

    /*
     *  Make the glass pane visible, start the wheel and change the cursor to the wait cursor
     */
    public void activate(boolean toggle) {
        wheel.setVisible(toggle);
        wheel.setBusy(toggle);
        super.setVisible( toggle );
        setCursor(getCursor());
        if(super.isVisible()){
            requestFocusInWindow();
        }
    }

    @Override
    public Cursor getCursor(){
        Cursor cursor = this.isVisible() ? GlassPane.WAIT_CURSOR : null; 
        return cursor;
    }

    /*
    *  Implement the KeyListener to consume events
    */
    public void keyPressed(KeyEvent e)  {
        e.consume();
    }
    public void keyReleased(KeyEvent e) {
        e.consume();
    }

    public void keyTyped(KeyEvent e) {}

}