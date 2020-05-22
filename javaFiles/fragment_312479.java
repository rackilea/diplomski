configRegistry.registerConfigAttribute(
    CellConfigAttributes.CELL_PAINTER,
    new BackgroundPainter(
            new PaddingDecorator(
                    new CellPainterDecorator(
                            new PaddingDecorator(new RichTextCellPainter(), 10, 0, 0, 0), 
                            CellEdgeEnum.LEFT, 
                            new ImagePainter()),
                    2, 5, 2, 5)),
    DisplayMode.NORMAL,
    ColumnLabelAccumulator.COLUMN_LABEL_PREFIX + 0);