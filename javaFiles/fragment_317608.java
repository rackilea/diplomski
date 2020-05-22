pane.setMinSize(cellSize, cellSize);
pane.setPrefSize(cellSize, cellSize);
pane.setMaxSize(cellSize, cellSize);
Month month = date.getMonth();
insets = new Insets(
        month != date.minusDays(1).getMonth() ? monthSepWidth/2 : 0,
        month != date.plusWeeks(1).getMonth() ? monthSepWidth/2 : 0,
        month != date.plusDays(1).getMonth()  ? monthSepWidth/2 : 0,
        month != date.minusWeeks(1).getMonth() ? monthSepWidth/2 : 0
);
pane.setBackground(new Background(new BackgroundFill(color,CornerRadii.EMPTY,insets)));