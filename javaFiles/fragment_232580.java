tChart1.getAspect().setView3D(false);

Contour series1 = new Contour(this.tChart1.getChart());

series1.fillSampleValues();

series1.setUseColorRange(true);
series1.setUsePalette(false);
series1.setStartColor(Color.GREEN);
series1.setEndColor(Color.RED);
series1.setMidColor(Color.TRANSPARENT);