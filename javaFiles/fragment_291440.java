FastBitmap fb = new FastBitmap(bufferedImage);

HistogramEqualization hist = new HistogramEqualization();
hist.applyInPlace(fb);

bufferedImage = fb.toBufferedImage();