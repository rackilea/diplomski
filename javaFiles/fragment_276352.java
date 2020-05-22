public class MyAdapter extends BaseAdapter {
    private MyActivity mActivity

    public MyAdapter(MyActivity activity) {
        mActivity = activity;
    }

    View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (int)v.getTag();
            // do stuff based on position or kelasList.get(position)
            // you can call mActivity.startActivity() if you need
        }
    };
    // similar for listener2,3,4

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // convert view = design
        View v = convertView;
        if (v == null) {
            holder = new ViewHolder();
            v = vi.inflate(Resource, null);
            holder.image_carikelas = (ImageView) v.findViewById(R.id.image_carikelas);
            holder.masterclass_name = (TextView) v.findViewById(R.id.masterclass_name);
            holder.studio_nama = (TextView) v.findViewById(R.id.studio_nama);
            holder.trainer_name = (TextView) v.findViewById(R.id.trainer_name);
            holder.area = (TextView) v.findViewById(R.id.area);
            holder.facility = (TextView) v.findViewById(R.id.facility);

            // set OnClickListeners
            holder.studio_nama.setOnClickListener(listener1);
            holder.trainer_name.setOnClickListener(listener2);
            holder.area.setOnClickListener(listener3);
            holder.facility.setOnClickListener(listener4);
            v.setTag(holder);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        //holder.imageview.setImageResource(R.drawable.promo_1);
        new DownloadImageTask(holder.image_carikelas).execute(kelasList.get(position).getImage());
        holder.masterclass_name.setText(kelasList.get(position).getName());
        holder.studio_nama.setText(kelasList.get(position).getStudio_nama());
        holder.trainer_name.setText("Trainer: " + kelasList.get(position).getTrainer_name());
        holder.area.setText("Area: " + kelasList.get(position).getArea());
        holder.facility.setText("Facility: " + kelasList.get(position).getFacility());

        // set tags
        holder.studio_nama.setTag(position);
        holder.trainer_name.setTag(position);
        holder.area.setTag(position);
        holder.facility.setTag(position);
        return v;

    }
}