public void componentResized(final ComponentEvent e)
{
    final double ratio = (double)getWidth() / (double)getHeight();

    layout.setRows((int) Math.sqrt(nbChannel / ratio));
    layout.setColumns(0);
}