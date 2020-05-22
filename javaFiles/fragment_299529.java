downloads.addListener(new ListChangeListener<Download>() {
    @Override
    public void onChanged(Change<? extends Download> c) {
        // this while was missing
        while (c.next()) {
            if (c.wasAdded()) {
                addDownloads(c.getAddedSubList());
            }
            if (c.wasRemoved()) {
                // accessing the list of removed elements is .. plain standard api 
                removeDownloads(c.getRemoved());
            }

        }
    }
});