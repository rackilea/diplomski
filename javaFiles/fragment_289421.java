@Override
    public void mousePressed( MouseEvent e ) {
        JComponent source = (JComponent)e.getComponent();
        source.putClientProperty( "Nimbus.State", "Pressed" );
        if (source instanceof JTableHeader) {
            ((JComponent) ((JTableHeader) source).getDefaultRenderer())
                .putClientProperty("Nimbus.State", "Pressed");
        }
    }