public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    Composite composite = new Composite(shell, SWT.NONE);
    composite.setLayout(new FillLayout());

    final Tree tree = new Tree(composite, SWT.NONE);
    for (int i = 0; i < 100; i++) {
        final TreeItem treeItem = new TreeItem(tree, SWT.NONE);
        treeItem.setText(String.format("item %d long                      name", i));
    }
    tree.addListener(SWT.DefaultSelection, new Listener() {
        @Override
        public void handleEvent(Event event) {
            tree.getParent().setRedraw(false);
            final Point originalSize = tree.getSize();
            final Point size = tree.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
            final Image image = new Image(display, size.x, size.y);
            final GC gc = new GC(image);

            tree.setSize(size);
            tree.print(gc);
            tree.setSize(originalSize);

            final ImageLoader loader = new ImageLoader();
            loader.data = new ImageData[]{image.getImageData()};
            final String pathToSave = "out.png";
            System.out.println(new File(pathToSave).getAbsolutePath());
            loader.save(pathToSave, SWT.IMAGE_PNG);
            gc.dispose();
            image.dispose();
            tree.getParent().setRedraw(true);
        }
    });

    shell.open();
    while (!shell.isDisposed()) {
        if (!display.readAndDispatch()) {
            display.sleep();
        }
    }
    display.dispose();
}