/**
 * Wrapps a {@link Tree} or {@link Table} to make it possible to work with them
 * in a generic way.
 * 
 * This class could be an interface in Java 8, which allows static methods on interfaces.
 */
public abstract class CollectionControl {
    public abstract CollectionItem[] getItems();
    public abstract CollectionItem[] getSelection();
    public abstract int getSelectionCount();
    public abstract Control getControl();
    public abstract int getColumnCount();

    interface CollectionItem {
        String getText(int columnIx);
    }

    /**
     * @param control Either a {@link Tree} or {@link Table}..
     * @return A collection which wraps the argument an delegate method calls to it.
     * @throws IllegalArgumentException if the argument is not a Tree or a Table.
     */
    public static CollectionControl create(Control control) {
        if (control instanceof Tree) {
            return new TreeControl((Tree) control);
        } else if (control instanceof Table) {
            return new TableControl((Table) control);
        }

        throw new IllegalArgumentException();
    }


    private static class TreeControl extends CollectionControl {
        private Tree tree;

        public TreeControl(Tree tree) {
            this.tree = tree;
        }

        @Override
        public CollectionItem[] getSelection() {
            CollectionItem[] items = new CollectionItem[tree.getSelectionCount()];
            int ix = 0;
            for (TreeItem item : tree.getSelection()) {
                items[ix++] = new TreeCollectionItem(item);
            }
            return items;
        }

        @Override
        public int getSelectionCount() {
            return tree.getSelectionCount();
        }

        @Override
        public Tree getControl() {
            return tree;
        }

        @Override
        public CollectionItem[] getItems() {
            CollectionItem[] items = new CollectionItem[tree.getItemCount()];
            int ix = 0;
            for (TreeItem item : tree.getItems()) {
                items[ix++] = new TreeCollectionItem(item);
            }
            return items;
        }

        @Override
        public int getColumnCount() {
            return tree.getColumnCount();
        }

        private static class TreeCollectionItem implements CollectionItem {
            private TreeItem item;
            public TreeCollectionItem(TreeItem item) {
                this.item = item;
            }
            @Override
            public String getText(int columnIx) {
                return item.getText(columnIx);
            }
        }
    }

    private static class TableControl extends CollectionControl {
        private Table table;

        public TableControl(Table table) {
            this.table = table;
        }

        @Override
        public CollectionItem[] getSelection() {
            CollectionItem[] items = new CollectionItem[table.getSelectionCount()];
            int ix = 0;
            for (TableItem item : table.getSelection()) {
                items[ix++] = new TableCollectionItem(item);
            }
            return items;
        }

        @Override
        public int getSelectionCount() {
            return table.getSelectionCount();
        }

        @Override
        public Table getControl() {
            return table;
        }

        @Override
        public CollectionItem[] getItems() {
            CollectionItem[] items = new CollectionItem[table.getItemCount()];
            int ix = 0;
            for (TableItem item : table.getItems()) {
                items[ix++] = new TableCollectionItem(item);
            }
            return items;
        }

        @Override
        public int getColumnCount() {
            return table.getColumnCount();
        }

        private static class TableCollectionItem implements CollectionItem {
            private TableItem item;
            public TableCollectionItem(TableItem item) {
                this.item = item;
            }
            @Override
            public String getText(int columnIx) {
                return item.getText(columnIx);
            }
        }
    }
}