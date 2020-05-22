Tree myWidget = treeViewer.getTree();
    Point size = myWidget.getSize();
    Image image = new Image(display, size.x, size.y);
    GC gc = new GC(myWidget);
    gc.copyArea(image, 0, 0);
    gc.dispose();

    // Get the ImageData and create a new printer Image from it
    ImageData imageData = image.getImageData();
    Image printImage = new Image(printer, imageData);

http://www.eclipse.org/swt/faq.php#noprintimage