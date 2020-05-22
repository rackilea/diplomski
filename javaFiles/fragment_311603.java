//Detail
    band = new JRDesignBand();
    band.setHeight(40);

    textField = new JRDesignTextField();
    textField.setX(0);
    textField.setY(0);
    textField.setWidth(200);
    textField.setHeight(40);
    textField.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    textField.setStyle(normalStyle);
    textField.setMarkup(JRCommonText.MARKUP_HTML);
    expression = new JRDesignExpression();
    expression.setText("\"<b>Name:   </b>\" + $F{Name} + \"<br/><b>Email: </b>\" + $F{Email}");
    textField.setExpression(expression);
    textField.getLineBox().getLeftPen().setLineWidth(1);
    textField.getLineBox().getTopPen().setLineWidth(1);
    textField.getLineBox().getRightPen().setLineWidth(1);
    textField.getLineBox().setLeftPadding(10);
    band.addElement(textField);

    ((JRDesignSection) jasperDesign.getDetailSection()).addBand(band);