JSlider slider = new JSlider(0, 100, 50);
  slider.setPaintLabels(true);
  slider.setPaintTicks(true);
  slider.setMajorTickSpacing(20);
  slider.setMinorTickSpacing(2);

  Dictionary<Integer, JLabel> labels = new Hashtable<>();
  for (int i = 0; i <= 100; i += 20) {
     labels.put(i, new JLabel(String.format("%.1f", i / 200.0)));
  }

  slider.setLabelTable(labels);