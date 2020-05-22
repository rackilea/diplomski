@NonNull
@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    View v = convertView;
    try {
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(resource, parent, false);

            holder = new CellHolder();
            holder.imageView = v.findViewById(R.id.imageView);
            holder.textViewTitle =  v.findViewById(R.id.textViewName);
            holder.textViewAddress =  v.findViewById(R.id.textViewDetail);
            holder.textViewPrice = v.findViewById(R.id.textViewDetail1);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String hotelTit = hotelTitle[position];
                    String hotelDescription1 = hotelDescription[position];
                    Integer imgPath = hotelsPics[position];
                    String hotelAdd = hotelAddress[position];

                    Bundle extras = new Bundle();
                    extras.putString("hotelTit",hotelTit);
                    extras.putString("hotelDescr",hotelDescription1);
                    extras.putInt("hotelImg", imgPath);
                    extras.putString("hotelAdd", hotelAdd);

                    Context context = PhotoListActivity.this;
                    Intent intent = new Intent(context, BookHotel.class);
                    ActivityOptions options = ActivityOptions.makeCustomAnimation(context, android.R.anim.fade_in, android.R.anim.fade_out);
                    intent.putExtras(extras);
                    context.startActivity(intent, options.toBundle());
                }
            });

            v.setTag(holder);
        } else {
            holder = (CellHolder)v.getTag();
        }

        // You can set the data here
        setData(id,holder);

    } catch (Exception e) {
        e.printStackTrace();
        e.getCause();
    }

    return v;
}