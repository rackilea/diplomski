public class CustomListAdapter extends ArrayAdapter<CustomObject> {

    private Context context;
    private int layoutResourceId_1;
    private int layoutResourceId_2
    private List<CustomObject> list;

    public CustomListAdapter(Context context, int layoutResourceId_1, int layoutResourceId_2, List<CustomObject> list) {
        super(context, layoutResourceId_1, list);
        this.context = context;
        this.layoutResourceId_1 = layoutResourceId_1;
        this.layoutResourceId_2 = layoutResourceId_2;
        this.list = list;
    }

    ...

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();

        if(condition_layout_1()) {
            row = layoutInflater.inflate(layoutResourceId_1, parent, false);
            // Use a holder to prepare item
            ...
        } else {
            row = layoutInflater.inflate(layoutResourceId_2, parent, false);
            // Use a holder to prepare item
            ...
        }

        return row;
    }

    ...
}