private UsbManager usbManager;
private UsbDevice clef;
ArrayList<File> images;

usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
clef = null;

if (usbManager != null)
{
    HashMap<String,UsbDevice> deviceList = usbManager.getDeviceList();
    if (deviceList != null)
    {
        Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
        while (deviceIterator.hasNext()) {
            clef = deviceIterator.next();
        }
    }
}

if (clef != null)
{
    File directory  = new File("/storage/UsbDriveA/");
    if (directory != null) {
        if (directory.canRead()) {

            images = new ArrayList<File>();
            String[] imageExtensions = {"jpg","jpeg","png","gif","JPG","JPEG","PNG","GIF"};
            Iterator<File> iterateImages = FileUtils.iterateFiles(directory, imageExtensions, true);
            while (iterateImages.hasNext()) {
                File theImage = iterateImages.next();
                if (!theImage.getName().startsWith(".", 0))
                    images.add(theImage);
            }

            // custom process / methods... not very relevant here : 
            imageIndex = 0;
            scale = 1.0f;
            countImgs = images.size();
            loadImage(imageIndex);
        }
    }
}