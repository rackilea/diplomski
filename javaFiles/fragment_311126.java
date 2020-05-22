public class MyAdapter extends ArrayAdapter<String> {
    private SparseBooleanArray enabledItems = new SparseBooleanArray(); 

    public MyAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return enabledItems.get(position, true);
    }

    public void toggleItem(int position) {
        boolean state = enabledItems.get(position, true);
        enabledItems.put(position, !state);
    }
}