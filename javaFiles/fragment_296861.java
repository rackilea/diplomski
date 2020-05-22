ObservableValue<Boolean> loading = EasyBind.select(cell.treeItemProperty())
    // ugly cast still here:
            .selectObject(treeItem -> ((LazyTreeItem)treeItem).loadingProperty());

    loading.addListener((obs, wasLoading, isNowLoading) -> {
        if (isNowLoading != null && isNowLoading.booleanValue()) {
            cell.setGraphic(progressBar);
        } else {
            cell.setGraphic(null);
        }
    });