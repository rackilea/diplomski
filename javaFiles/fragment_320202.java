Number maximum = DatasetUtilities.findMaximumRangeValue(dataset);
ValueMarker max = new ValueMarker(maximum.floatValue());
max.setPaint(Color.orange);
max.setLabel("Highest Value");
max.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
plot.addRangeMarker(max,Layer.BACKGROUND);