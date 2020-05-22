public static void main ( String[] args )
{
    JFrame controls = new JFrame ();

    controls.add ( new JComponent ()
    {
        private Point location = new Point ( 250, 250 );
        private int speed = 5;

        {
            setFocusable ( true );
            requestFocusInWindow ();
            addKeyListener ( new KeyAdapter ()
            {
                public void keyPressed ( KeyEvent e )
                {
                    boolean changed = false;
                    if ( e.getKeyCode () == KeyEvent.VK_W || e.getKeyCode () == KeyEvent.VK_UP )
                    {
                        location.y -= speed;
                        changed = true;
                    }
                    else if ( e.getKeyCode () == KeyEvent.VK_A ||
                            e.getKeyCode () == KeyEvent.VK_LEFT )
                    {
                        location.x -= speed;
                        changed = true;
                    }
                    else if ( e.getKeyCode () == KeyEvent.VK_S ||
                            e.getKeyCode () == KeyEvent.VK_DOWN )
                    {
                        location.y += speed;
                        changed = true;
                    }
                    else if ( e.getKeyCode () == KeyEvent.VK_D ||
                            e.getKeyCode () == KeyEvent.VK_RIGHT )
                    {
                        location.x += speed;
                        changed = true;
                    }
                    if ( changed )
                    {
                        repaint ();
                    }
                }
            } );
        }

        protected void paintComponent ( Graphics g )
        {
            Graphics2D g2d = ( Graphics2D ) g;
            g2d.setRenderingHint ( RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON );

            g2d.setPaint ( Color.BLACK );
            g2d.drawOval ( location.x - 10, location.y - 10, 20, 20 );
        }
    } );

    controls.setSize ( 500, 500 );
    controls.setLocationRelativeTo ( null );
    controls.setDefaultCloseOperation ( JFrame.EXIT_ON_CLOSE );
    controls.setVisible ( true );
}