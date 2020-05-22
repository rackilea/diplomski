private static Map<String, TreeItem> nodes = new HashMap<>();
private static Map<TreeItem, List<String>> children = new HashMap<>();

public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Tree tree = new Tree(shell, SWT.BORDER);

    Path path = FileSystems.getDefault().getPath("/home/baz/TestFolder/", new String[] {});
    try {
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            {
                TreeItem parent = nodes.get(dir.getParent().toString());
                TreeItem item = null;
                if(parent == null)
                {
                    item = new TreeItem(tree, SWT.NONE);
                }
                else
                {
                    item = new TreeItem(parent, SWT.NONE);
                }
                item.setText(dir.getFileName().toString());

                nodes.put(dir.toString(), item);

                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs)
            {
                TreeItem parent = nodes.get(dir.getParent().toString());

                if(children.get(parent) == null)
                    children.put(parent, new ArrayList<String>());

                children.get(parent).add(dir.getFileName().toString());

                return FileVisitResult.CONTINUE;
            }
        });
    } catch (IOException e) {
        e.printStackTrace();
    }

    for(TreeItem parent : children.keySet())
    {
        for(String child : children.get(parent))
        {
            TreeItem item = new TreeItem(parent, SWT.NONE);
            item.setText(child);
        }

    }

    tree.layout();
    nodes = null;
    children = null;

    shell.setSize(400,400);
    shell.open();

    while (!shell.isDisposed()) {
        if (!display.readAndDispatch())
            display.sleep();
    }

    display.dispose();
}