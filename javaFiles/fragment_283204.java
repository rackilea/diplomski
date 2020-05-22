natTable.addConfiguration(new AbstractRegistryConfiguration() {

    @Override
    public void configureRegistry(IConfigRegistry configRegistry) {
        configRegistry.registerConfigAttribute(CellConfigAttributes.CELL_PAINTER,
                new CellPainterDecorator(
                        new TextPainter(),
                        CellEdgeEnum.LEFT,
                        new ImagePainter() {
                            @Override
                            protected Image getImage(ILayerCell cell, IConfigRegistry configRegistry) {
                                return image;
                            }

                        }),
                DisplayMode.NORMAL,
                "MARRIED");
    }
});