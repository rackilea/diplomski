table.getColumn(1).setCellRenderer(new DefaultTableRenderer(
        new WrappingProvider(IconValues.NONE, new ButtonProvider(), false) {

            @Override
            protected void configureState(CellContext context) {
                super.configureState(context);
                rendererComponent.getComponent().setVisible(context.getRow() != 5);
            }

        }
));