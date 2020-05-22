private class MyColoringAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> values;

    public MyColoringAdapter(Context context, ArrayList<String> values) {
        super(context, R.layout.list_item, values);
        this.context = context;
        this.values = values;
    }