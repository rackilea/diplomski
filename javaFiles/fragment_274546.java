public class ListAdapter extends ArrayAdapter<Model> {


    private Context activityContext;
    private List<Model> list;
    public static final String TAG = "ListView";

    public ListAdapter(Context context, List<Model> list){
        super(context, R.layout.single_listview, list);
        this.activityContext = context;
        this.list = list;
    }


    @Override
    public View getView(final int position, View view, ViewGroup viewGroup){

        final ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(activityContext).inflate(R.layout.single_listview, null);
            viewHolder = new ViewHolder();

            viewHolder.top = (TextView) view.findViewById(R.id.top);
            viewHolder.bottom = (TextView) view.findViewById(R.id.bottom);

            viewHolder.top.setText(list.get(position).getTop());
            viewHolder.bottom.setText(list.get(position).getBottom());

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        return view;
    }

    private static class ViewHolder {

        TextView top;
        TextView bottom;
    }


}