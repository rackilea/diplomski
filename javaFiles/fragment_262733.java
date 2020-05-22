public JasperDesign setImage(Boolean isImageAvailable) throws JRException {
  JasperDesign jasperDesign = new JasperDesign();
  jasperDesign.setName("NoXmlDesignReport");
  jasperDesign.setPageWidth(595);
  jasperDesign.setPageHeight(842);
  jasperDesign.setColumnWidth(515);
  jasperDesign.setColumnSpacing(0);
  jasperDesign.setLeftMargin(40);
  jasperDesign.setRightMargin(40);
  jasperDesign.setTopMargin(20);
  jasperDesign.setBottomMargin(20);
  JRDesignBand band = new JRDesignBand();
  band.setHeight(200);

  JRDesignTextField textField = new JRDesignTextField();
  textField.setX(350);//Your desired x position when image is not available.
  textField.setY(0);//Your desired y position when image is not available.
  textField.setWidth(100);
  textField.setHeight(20);
  textField.setStyle(normalStyle);
  textField.setStretchWithOverflow(true);
  textField.setPositionType(PositionTypeEnum.FLOAT);
  textField.setBlankWhenNull(true);
  JRDesignExpression expression = new JRDesignExpression();
  expression.setText("$F{" + fieldName + "}");
  textField.setExpression(expression);

  if(isImageAvailable) {
    JRDesignImage jrDesignImage = new JRDesignImage(jasperDesign);
    expression = new JRDesignExpression();
    expression.setText("\"/path/to/image.png\"");
    jrDesignImage.setExpression(expression);
    jrDesignImage.setHorizontalAlignment(HorizontalAlignEnum.LEFT);
    jrDesignImage.setX(400);
    jrDesignImage.setY(25);
    jrDesignImage.setWidth(93);
    jrDesignImage.setHeight(100);
    jrDesignImage.setScaleImage(ScaleImageEnum.RETAIN_SHAPE);
    band.addElement(jrDesignImage);
    textField.setX(10);//Your desired x position when image is available.
    textField.setY(0);//Your desired y position when image is available.
  }

  band.addElement(textField);
  jasperDesign.setTitle(band);
  return jasperDesign;
}