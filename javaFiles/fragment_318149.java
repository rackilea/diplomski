DefaultGlazedListsStaticFilterStrategy filterStrategy = new DefaultGlazedListsStaticFilterStrategy(
                    bodyLayerStack.getFilterList(),
                    columnPropertyAccessor,
                    configRegistry);

FilterRowHeaderComposite filterRowHeaderLayer =
        new FilterRowHeaderComposite(
                filterStrategy,
                columnHeaderLayer,
                columnHeaderDataLayer.getDataProvider(),
                configRegistry);