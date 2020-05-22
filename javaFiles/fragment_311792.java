public class ListAdapter extends ArrayAdapter<Item> {

    private int resourceLayout;
    private Context mContext;
    private ArrayList<Contact> contacts;

    public ListAdapter(Context context, int resource, ArrayList<Contact> contacts) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
        this.contacts = contacts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Item p = getItem(position);

        if (p != null) {
            Button btn = (TextView) v.findViewById(R.id.button1);

            if (btn != null) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(position == 1) implementSomethingFor1();
                        else if (position == 2) implementSomethingFor2();
                        // ... Define the other implementations
                    }
                });
            }
        }

        return v;
    }
}