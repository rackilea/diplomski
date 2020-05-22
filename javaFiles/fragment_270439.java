public class ListAdapter extends BaseAdapter{

    List<String> mPlaces ;
    Context mContext ;
    LayoutInflater mInflater ;
    PlaceClickInterface mPlaceClickInterface;

    public ListAdapter( List places , DemoListView demoListView) {
        this.mContext = demoListView.getBaseContext() ;
        this.mPlaces = places ;
        this.mInflater =(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mPlaceClickInterface = (PlaceClickInterface) demoListView;
    }

    @Override
    public int getCount() {
        return mPlaces.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlaces.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_list_data, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bind(holder ,position);
        return convertView ;
    }

    private class ViewHolder{

        TextView places ;
        ViewHolder(View view){
            this.places = (TextView) view.findViewById(R.id.list_place);
        }
        // used to populate the list with list item and attach click listener on each item
        void bind(ViewHolder holder ,final int position){
            holder.places.setText(mPlaces.get(position));
            holder.places.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlaceClickInterface.onPlaceClick(position);
                }
            });
        }
    }

    public interface PlaceClickInterface {
        void onPlaceClick(int position) ;
    }
}