ObservableListContentProvider contentProvider = new ObservableListContentProvider();
if (viewer.getInput() != null)
    viewer.setInput(null);
viewer.setContentProvider(contentProvider);
viewer.setLabelProvider(new ObservableMapLabelProvider(Properties
        .observeEach(contentProvider.getKnownElements(),
                    labelProperties)));
if (input != null)
    viewer.setInput(input);