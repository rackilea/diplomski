List<ParseObject> parse = new ArrayList<ParseObject>();

public class CustomChannelListAdapter extends BaseAdapter {

    private Context context;

    public CustomChannelListAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        if (parse != null) {
            return parse.size();
        }
        return 0;
    }

    @Override
    public Channel getItem(int position) {
        // TODO Auto-generated method stub
        return parse.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        TextView tittle = null;
        TextView desc = null;
        TextView nowPlaying = null;
        if (view == null) {
            LayoutInflater inflater = ((Activity) context)
                    .getLayoutInflater();
            view = inflater.inflate(R.layout.video_listrow, parent, false);

        } else {
            view = convertView;
        }
        tittle = (TextView) view.findViewById(R.id.title);
        desc = (TextView) view.findViewById(R.id.Descp);

        nowPlaying = (TextView) view.findViewById(R.id.NowplayingId);
        if (parse!= null) {

            if (parse.get(position).getName() != null) {
                tittle.setText(parse.get(position).getName()
                        .toString());
            } else {
                tittle.setText("----------------------");
            }

            if (parse.get(position).getDesc() != null) {
                desc.setText(parse.get(position).getDesc()
                        .toString());
            } else {
                desc.setText("------------------------");
            }

        } 
        return view;
    }

}