public static Stroke setupStroke ( final Graphics2D g2d, final Stroke stroke )
{
    return setupStroke ( g2d, stroke, true );
}

public static Stroke setupStroke ( final Graphics2D g2d, final Stroke stroke, final boolean shouldSetup )
{
    if ( shouldSetup && stroke != null )
    {
        final Stroke old = g2d.getStroke ();
        g2d.setStroke ( stroke );
        return old;
    }
    else
    {
        return null;
    }
}

public static void restoreStroke ( final Graphics2D g2d, final Stroke stroke )
{
    restoreStroke ( g2d, stroke, true );
}

public static void restoreStroke ( final Graphics2D g2d, final Stroke stroke, final boolean shouldRestore )
{
    if ( shouldRestore && stroke != null )
    {
        g2d.setStroke ( stroke );
    }
}