public class FilesTree implements Runnable {

static CustomTree filetree = new CustomTree();
;
public static TreeView<File> tv = new TreeView();
public static Image folderCollapseImage = new Image(ClassLoader.getSystemResourceAsStream("ui/folder.png"));
public static Image folderExpandImage = new Image(ClassLoader.getSystemResourceAsStream("ui/folder-open.png"));
public static Image fileImage = new Image(ClassLoader.getSystemResourceAsStream("ui/file.png"));

SQLiteJDBC treedb = new SQLiteJDBC();
String sql;
ResultSet rs;
int totalFolder = 0;
int totalFile = 0;
File[] filelist;
File f = new File("workspace");
int timeout = 0;

public FilesTree() {

    //  this.getTree();
}

private TreeView buildFileSystemBrowser() {
    TreeItem<File> root = createNode(new File("workspace"));
    return new TreeView<File>(root);
}

// This method creates a TreeItem to represent the given File. It does this
// by overriding the TreeItem.getChildren() and TreeItem.isLeaf() methods 
// anonymously, but this could be better abstracted by creating a 
// 'FileTreeItem' subclass of TreeItem. However, this is left as an exercise
// for the reader.
private TreeItem<File> createNode(final File f) {
    return new TreeItem<File>(f) {
        // We cache whether the File is a leaf or not. A File is a leaf if
        // it is not a directory and does not have any files contained within
        // it. We cache this as isLeaf() is called often, and doing the 
        // actual check on File is expensive.
        private boolean isLeaf;

        // We do the children and leaf testing only once, and then set these
        // booleans to false so that we do not check again during this
        // run. A more complete implementation may need to handle more 
        // dynamic file system situations (such as where a folder has files
        // added after the TreeView is shown). Again, this is left as an
        // exercise for the reader.
        private boolean isFirstTimeChildren = true;
        private boolean isFirstTimeLeaf = true;

        @Override
        public ObservableList<TreeItem<File>> getChildren() {
            if (isFirstTimeChildren) {
                isFirstTimeChildren = false;

                // First getChildren() call, so we actually go off and 
                // determine the children of the File contained in this TreeItem.
                super.setExpanded(true);
                this.setExpanded(true);
                super.getChildren().setAll(buildChildren(this));
            }

            return super.getChildren();
        }

        @Override
        public boolean isLeaf() {
            if (isFirstTimeLeaf) {
                isFirstTimeLeaf = false;
                File f = (File) getValue();
                isLeaf = f.isFile();
            }

            return isLeaf;
        }

        private ObservableList<TreeItem<File>> buildChildren(TreeItem<File> TreeItem) {
            File f = TreeItem.getValue();
            if (f != null && f.isDirectory()) {
                // super.setGraphic(new ImageView(folderCollapseImage));
                File[] files = f.listFiles();
                TreeItem.setExpanded(true);
                if (files != null) {
                    ObservableList<TreeItem<File>> children = FXCollections.observableArrayList();

                    for (int i = 0; i < files.length; i++) {

                        children.add(createNode(files[i]));
                        if (files[i].isDirectory()) {
                            children.get(i).setGraphic(new ImageView(folderCollapseImage));
                        } else {
                            children.get(i).setGraphic(new ImageView(fileImage));

                        }
                        children.get(i).addEventHandler(TreeItem.branchCollapsedEvent(), new EventHandler() {
                            @Override
                            public void handle(Event e) {
                                TreeItem<File> source = (TreeItem<File>) e.getSource();
                               File source2= source.getValue();
                                if (source2.isDirectory() && !source.isExpanded()) {
                                    ImageView iv = (ImageView) source.getGraphic();
                                    iv.setImage(folderCollapseImage);
                                }
                            }
                        });
                        children.get(i).addEventHandler(TreeItem.branchExpandedEvent(), new EventHandler() {
                            @Override
                            public void handle(Event e) {
                                TreeItem<File> source = (TreeItem<File>) e.getSource();
                               File source2= source.getValue();
                                if (source2.isDirectory() && source.isExpanded()) {
                                    ImageView iv = (ImageView) source.getGraphic();
                                    iv.setImage(folderExpandImage);
                                }
                            }
                        });

                    }
                    return children;
                }
            }

            return FXCollections.emptyObservableList();
        }
    };
}

@Override
public void run() {
    //while (true) 
    {
        filetree.setSimpleRoot(f.getName());
        tv = this.buildFileSystemBrowser();
        tv.getRoot().setExpanded(true);
        //tv.setSelectionModel(null);
        tv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() % 2 == 0) {
                    MultipleSelectionModel msm = tv.getSelectionModel();
                    TreeItem<File> item = (TreeItem<File>) msm.getSelectedItem();
                    System.out.println("Selected Text : " + item.getValue());

                    // Create New Tab
                } else {

                    MultipleSelectionModel msm = tv.getSelectionModel();
                    TreeItem<File> item = (TreeItem<File>) msm.getSelectedItem();
                    System.out.println("Selected Text : " + item.getValue().getAbsolutePath());

                }
            }
        });
    }
 }
}