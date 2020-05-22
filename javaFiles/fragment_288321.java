public class CampsitesListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<Campsites> list;

    public CampsitesListAdapter(Context mContext , List<Campsites> countries) {
        this.mContext = mContext;
        this.list = countries;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(mContext, R.layout.campsite_layout , null );
        TextView name = (TextView) view.findViewById(R.id.nametxt);
        Textview city = (Textview) view.findViewById(R.id.citytxt);
        Textview feature = (Textview) view.findViewById(R.id.featuretxt);

        name.setText(list.get(position).getname());
        city.setText(list.get(position).getcity());
        feature.setText(list.get(position).getfeature());

        return view;
    }
 }