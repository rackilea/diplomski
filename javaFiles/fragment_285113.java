Robot r = new Robot();
Rectangle rect = new Rectangle(10,10,200,200);
BufferedImage capture = r.createScreenCapture(rect);

FastBitmap fb = new FastBitmap(capture);
fb.toGrayscale();

FourierTransform ft = new FourierTransform(fb);
ft.Forward();
fb = ft.toFastBitmap();

//Display the image
JOptionPane.showMessageDialog(null, fb.toIcon());