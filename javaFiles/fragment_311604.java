//Detail
    band = new JRDesignBand();
    band.setHeight(40);

    JRDesignStaticText staticText = new JRDesignStaticText();
    staticText.setX(0);
    staticText.setY(0);
    staticText.setWidth(60);
    staticText.setHeight(20);
    staticText.setMode(ModeEnum.OPAQUE);
    staticText.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    staticText.setStyle(boldStyle);
    staticText.setText("Name: ");
    staticText.getLineBox().getLeftPen().setLineWidth(1);
    staticText.getLineBox().getTopPen().setLineWidth(1);
    staticText.getLineBox().setLeftPadding(10);
    band.addElement(staticText);

    textField = new JRDesignTextField();
    textField.setX(60);
    textField.setY(0);
    textField.setWidth(200);
    textField.setHeight(20);
    textField.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    textField.setStyle(normalStyle);
    expression = new JRDesignExpression();
    expression.setText("$F{Name}");
    textField.setExpression(expression);
    textField.getLineBox().getTopPen().setLineWidth(1);
    textField.getLineBox().getRightPen().setLineWidth(1);
    textField.getLineBox().setLeftPadding(10);
    band.addElement(textField);

    staticText = new JRDesignStaticText();
    staticText.setX(0);
    staticText.setY(20);
    staticText.setWidth(60);
    staticText.setHeight(20);
    staticText.setMode(ModeEnum.OPAQUE);
    staticText.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    staticText.setStyle(boldStyle);
    staticText.setText("Email: ");
    staticText.getLineBox().getLeftPen().setLineWidth(1);
    staticText.getLineBox().getBottomPen().setLineWidth(1);
    staticText.getLineBox().setLeftPadding(10);
    band.addElement(staticText);

    textField = new JRDesignTextField();
    textField.setStretchWithOverflow(true);
    textField.setX(60);
    textField.setY(20);
    textField.setWidth(200);
    textField.setHeight(20);
    textField.setPositionType(PositionTypeEnum.FLOAT);
    textField.setStyle(normalStyle);
    expression = new JRDesignExpression();
    expression.setText("$F{Email}");
    textField.setExpression(expression);
    textField.getLineBox().getRightPen().setLineWidth(1);
    textField.getLineBox().getBottomPen().setLineWidth(1);
    textField.getLineBox().setLeftPadding(10);
    band.addElement(textField);

    ((JRDesignSection) jasperDesign.getDetailSection()).addBand(band);