BarRenderer renderer = (BarRenderer) plot.getRenderer();
CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator("{1}", NumberFormat.getInstance());
renderer.setBaseItemLabelGenerator(generator);
renderer.setBaseItemLabelFont(new Font("Arial", Font.BOLD, 7));
renderer.setBaseItemLabelsVisible(true);
renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT, TextAnchor.CENTER, 0.0));

ItemLabelPosition p2 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, 0.0);
renderer.setPositiveItemLabelPositionFallback(p2);