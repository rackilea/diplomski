band = new JRDesignBand();
    band.setHeight(110);

    String imgPath1 = "\"jasperreports.png\"";
    String imgPath2 = "\"js_logo.png\"";
    int img1Width = 105;
    int img2Width = 200;
    int distance = 20;

    expression = new JRDesignExpression();
    expression.setText(imgPath1);

    JRDesignImage image = new JRDesignImage(jasperDesign);
    image.setX(0);
    image.setY(0);
    image.setWidth(img1Width);
    image.setHeight(26);
    image.setScaleImage(ScaleImageEnum.FILL_FRAME);
    image.setExpression(expression);

    band.addElement(image);

    expression = new JRDesignExpression();
    expression.setText(imgPath2);

    image = new JRDesignImage(jasperDesign);
    image.setX(distance + img1Width);
    image.setY(0);
    image.setWidth(img2Width);
    image.setHeight(87);
    image.setScaleImage(ScaleImageEnum.FILL_FRAME);
    image.setExpression(expression);

    band.addElement(image);

    expression = new JRDesignExpression();
    expression.setText(imgPath1);

    image = new JRDesignImage(jasperDesign);
    image.setX(2*distance + img1Width + img2Width);
    image.setY(0);
    image.setWidth(img1Width);
    image.setHeight(26);
    image.setScaleImage(ScaleImageEnum.FILL_FRAME);
    image.setExpression(expression);

    band.addElement(image);

    JRDesignStaticText staticText = new JRDesignStaticText();
    staticText.setX(200);
    staticText.setY(90);
    staticText.setWidth(60);
    staticText.setHeight(20);
    staticText.setMode(ModeEnum.OPAQUE);
    staticText.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    staticText.setStyle(boldStyle);
    staticText.setText("The title above images");

    band.addElement(staticText);

    ((JRDesignSection) jasperDesign.getDetailSection()).addBand(band);