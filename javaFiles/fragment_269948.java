public static void main(String[] args)
{
    Display display = Display.getDefault();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Tree tree = new Tree(shell, SWT.NONE);
    tree.setHeaderVisible(true);        

    TreeColumn column1 = new TreeColumn(tree, SWT.LEFT);
    column1.setText("Column 1");
    column1.setWidth(50);
    TreeColumn column2 = new TreeColumn(tree, SWT.LEFT);
    column2.setText("Column 2");
    column2.setWidth(50);
    TreeColumn column3 = new TreeColumn(tree, SWT.LEFT);
    column3.setText("Column 3");
    column3.setWidth(50);

    Image image = YOUR_IMAGE_HERE;

    TreeItem item = new TreeItem(tree, SWT.NONE);
    item.setImage(0, image);
    item.setImage(1, image);
    item.setImage(2, image);

    shell.pack();
    shell.open();

    while(!shell.isDisposed())
    {
        if(!display.readAndDispatch())
            display.sleep();
    }
}