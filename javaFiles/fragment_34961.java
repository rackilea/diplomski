public class ItemArrayAdapter extends ArrayAdapter<Item> {

        private int listItemLayout;
        ImageButton deleteButton;
        private ArrayList<Item> itemList;

        public ItemArrayAdapter(Context context, int layoutId, ArrayList<Item> itemList) {
            super(context, layoutId, itemList);
            listItemLayout = layoutId;
            this.itemList = itemList;
        }