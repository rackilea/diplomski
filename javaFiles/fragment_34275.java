tChart1.getAspect().setView3D(false);

Bar bar1 = new Bar(tChart1.getChart());
bar1.fillSampleValues();

tChart1.getPanel().setMarginUnits(PanelMarginUnits.PIXELS);
tChart1.getPanel().setMarginTop(30);

tChart1.getHeader().setCustomPosition(true);
tChart1.getHeader().setTop(7);    
int width = tChart1.getGraphics3D().textWidth(tChart1.getHeader().getText());
tChart1.getHeader().setLeft(getWindowManager().getDefaultDisplay().getWidth()/2 - width/2);