JColorChooser chooser = new JColorChooser();
List<AbstractColorChooserPanel> choosers = 
        new ArrayList<>(Arrays.asList(chooser.getChooserPanels()));
choosers.remove(0);
MySwatchChooserPanel swatch = new MySwatchChooserPanel();
choosers.add(0, swatch);
chooser.setChooserPanels(choosers.toArray(new AbstractColorChooserPanel[0]));