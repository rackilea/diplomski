JPanel cmdList = new JPanel()
{
    @Override
    public Dimension getPreferredSize()
    {
        Dimension preferredSize = super.getPreferredSize();

        Border border =    getBorder();
        int borderWidth = 0;

     if (border instanceof TitledBorder)
     {
         Insets insets = getInsets();
         TitledBorder titledBorder = (TitledBorder)border;
         borderWidth = titledBorder.getMinimumSize(this).width + insets.left + insets.right;
     }

     int preferredWidth = Math.max(preferredSize.width, borderWidth);

     return new Dimension(preferredWidth, preferredSize.height);
    }
};