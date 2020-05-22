private void grid_onAttach(final AttachEvent event)
{

    final EmbeddedStorageManager storage = dbHandler.getStoragemanager();

    if(storage.root() == null)
    {
        System.out.println("No existing Database found ");
    }
    else
    {
        System.out.println("Existing Database found: ");
        final dataRoot root = (dataRoot)storage.root();
        this.grid.setDataProvider(DataProvider.ofCollection(root.getAllCabinets()));

    }

}