private SpeedometerView speedometer;

// Customize SpeedometerView
speedometer = (SpeedometerView) v.findViewById(R.id.speedometer);

// Add label converter
speedometer.setLabelConverter(new SpeedometerView.LabelConverter() {
  @Override
  public String getLabelFor(double progress, double maxProgress) {
      return String.valueOf((int) Math.round(progress));
  }
});

// configure value range and ticks
speedometer.setMaxSpeed(300);
speedometer.setMajorTickStep(30);
speedometer.setMinorTicks(2);

// Configure value range colors
speedometer.addColoredRange(30, 140, Color.GREEN);
speedometer.addColoredRange(140, 180, Color.YELLOW);
speedometer.addColoredRange(180, 400, Color.RED);