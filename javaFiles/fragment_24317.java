public static void adjustWidthForTitle(JDialog dialog)
{
    // make sure that the dialog is not smaller than its title
    // this is not an ideal method, but I can't figure out a better one
    Font defaultFont = UIManager.getDefaults().getFont("Label.font");
    int titleStringWidth = SwingUtilities.computeStringWidth(new JLabel().getFontMetrics(defaultFont),
            dialog.getTitle());

    // account for titlebar button widths. (estimated)
    titleStringWidth += 110;

    // set minimum width
    Dimension currentPreferred = dialog.getPreferredSize();

    // +10 accounts for the three dots that are appended when the title is too long
    if(currentPreferred.getWidth() + 10 <= titleStringWidth)
    {
        dialog.setPreferredSize(new Dimension(titleStringWidth, (int) currentPreferred.getHeight()));

    }
}