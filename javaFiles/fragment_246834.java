public static void main ( String[] args )
{
    JButton orangeButton = new JButton ( "X" );
    orangeButton.setUI ( new MyButtonUI ());
}

private static class MyButtonUI extends BasicButtonUI
{
    public void paint ( Graphics g, JComponent c )
    {
        JButton myButton = ( JButton ) c;
        ButtonModel buttonModel = myButton.getModel ();

        if ( buttonModel.isPressed () || buttonModel.isSelected () )
        {
            g.setColor ( Color.GRAY );
        }
        else
        {
            g.setColor ( Color.ORANGE );
        }
        g.fillRect ( 0, 0, c.getWidth (), c.getHeight () );

        super.paint ( g, c );
    }
}