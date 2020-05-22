table.setSelectionModel(selectionModel, 
    DefaultSelectionEventManager.createCustomManager(
        new DefaultSelectionEventManager.CheckboxEventTranslator<T>() {
            @Override
            public SelectAction translateSelectionEvent(CellPreviewEvent<T> event) {
                SelectAction action = super.translateSelectionEvent(event);
                if (action.equals(SelectAction.IGNORE)) {
                    GWT.log("DO WHAT YOU WANT!!!");
                    return SelectAction.IGNORE;
                }
                return action;
            }
        }
    )
);