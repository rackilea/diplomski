Info imageInfo = new Info(brandingURL, true);
 IMOperation op = new IMOperation();
 op.addImage(brandingURL);
 op.size(imageInfo.getImageWidth(), imageInfo.getImageHeight());
 op.addImage("xc:white", "c://write//test.jpeg");
 op.addImage("c://write//test.jpeg");
 CompositeCmd composite = new CompositeCmd();
 composite.run(op);