htmlPanel.setVisible(true); 
    htmlPanel.setPreferredWidth(DEFAULT_PAGE_WIDTH);
    logger.info("Calculating preferred size");

    // Get the preferred heigth for the current width.
    Dimension psvz = htmlPanel.getPreferredSize();
    Dimension min = htmlPanel.getMinimumSize();

    logger.info("prf :" + psvz);
    logger.info("min :" + min);

    // Enlarge to the minimum width (with a limit)
    int width = Math.min(MAX_PAGE_WIDTH, Math.max(DEFAULT_PAGE_WIDTH,
            psvz.width));
    int height = psvz.height;

    logger.info("width :" + width);
    logger.info("heigth :" + height);

    htmlPanel.setSize(width, height);

            // actually, htmlPanel is a subclass, and this method exposes validateTree. It may work without it.
    htmlPanel.forceValidateTree(); 

    htmlPanel.doLayout();

    setImageSize(width);
    logger.info("actual size:" + htmlPanel.getSize());