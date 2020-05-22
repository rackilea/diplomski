FastBitmap fb = new FastBitmap("c:\\yourImage.bmp");

fb.toGrayscale();

Threshold t = new Threshold(120);
t.applyInPlace(fb);

// Your objects.
BlobDetection bd = new BlobDetection();
ArrayList<Blob> blobs = bd.ProcessImage(fb);