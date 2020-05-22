class InfoAdapter extends BaseAdapter {

    Context context;
    List<Info> data;
    private static LayoutInflater inflater = null;

    public InfoAdapter(Context context, List<Info> data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        TextView name = (TextView) vi.findViewById(R.id.name);
        TextView email = (TextView) vi.findViewById(R.id.email);
        name.setText(data.get(position).getName());
        email.setText(data.get(position).getEmail());

        return vi;
    }
}