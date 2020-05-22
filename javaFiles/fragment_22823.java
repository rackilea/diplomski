private List<GridViewItem> createGridItems(String directoryPath) {
    List<GridViewItem> items = new ArrayList<>();

    // List all the items within the folder.
    File[]  files = new File(directoryPath).listFiles(new ImageFileFilter());
    if (files != null) {  // check here for null
        for (File file : files) {
            // Add the directories containing images or sub-directories
            if (file.isDirectory()
                    && file.listFiles(new ImageFileFilter()).length > 0) {

                items.add(new GridViewItem(file.getAbsolutePath(), true, null));
            }
            // Add the images
            else {
                Bitmap image = BitmapHelper.decodeBitmapFromFile(file.getAbsolutePath(),
                        50,
                        50);
                items.add(new GridViewItem(file.getAbsolutePath(), false, image));
            }
        }
    }

    return items;
}