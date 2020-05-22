OMFactory fac = OMAbstractFactory.getOMFactory();
OMElement test1 = fac.createOMElement("test1", "", "");
OMElement t1 = fac.createOMElement("t", "", "");

t1.setText("1");
test1.addChild(t1);