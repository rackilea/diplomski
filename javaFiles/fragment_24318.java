JDialog dialog = new JDialog()
    {
        @Override
        public Dimension getPreferredSize()
        {
            Dimension retVal = super.getPreferredSize();

            String title = this.getTitle();

            if(title != null)
            {
                Font defaultFont = UIManager.getDefaults().getFont("Label.font");
                int titleStringWidth = SwingUtilities.computeStringWidth(new JLabel().getFontMetrics(defaultFont),
                        title);

                // account for titlebar button widths. (estimated)
                titleStringWidth += 110;

                // +10 accounts for the three dots that are appended when
                // the title is too long
                if(retVal.getWidth() + 10 <= titleStringWidth)
                {
                    retVal = new Dimension(titleStringWidth, (int) retVal.getHeight());
                }
            }
            return retVal;
        }

    };