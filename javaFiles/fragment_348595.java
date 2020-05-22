public class Example
{
    public static void main ( String[] args )
    {
        final MyObject object = new MyObject ();

        final JScrollPane scrollPane = new JScrollPane ( object )
        {
            public Dimension getPreferredSize ()
            {
                final Dimension ps = super.getPreferredSize ();
                final JScrollBar vsb = getVerticalScrollBar ();
                final Insets i = getInsets ();
                ps.width = object.getPreferredWidth () + ( vsb.isShowing () ? vsb.getPreferredSize ().width : 0 ) + i.left + i.right;
                return ps;
            }
        };
    }

    public static class MyObject extends JPanel
    {
        public Dimension getPreferredSize ()
        {
            final Dimension ps = super.getPreferredSize ();
            ps.width = 0;
            return ps;
        }

        public int getPreferredWidth ()
        {
            return super.getPreferredSize ().width;
        }
    }
}