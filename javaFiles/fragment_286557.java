public float getBaseElevation() {
    return baseElevation;
}

@Override
public CardView getCardViewAt(int position) {
    return mViews.get(position);
}

@Override
public int getCount() {
    return mData.size();
}

@Override
public boolean isViewFromObject(View view, Object object) {
    return view == object;
}


@Override
public Object instantiateItem(final ViewGroup container, int position)  {

    View view = LayoutInflater.from(container.getContext())
            .inflate(R.layout.item_servicios, container, false);

    container.addView(view);
    bind(mData.get(position), view, container.getContext());
    CardView cardView = (CardView) view.findViewById(R.id.cardView);


    /*if (baseElevation == 0) {
        baseElevation = cardView.getCardElevation();
    }*/

    final int page = position;

    Button button =(Button)view.findViewById(R.id.button_service);

    cardView.setMaxCardElevation(baseElevation * MAX_ELEVATION_FACTOR);
    mViews.set(position, cardView);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (page ==0 ){

                Intent intent = new Intent(container.getContext(), Login_Activity.class);
                container.getContext().startActivity(intent);

                Toast.makeText(container.getContext(),"Aseo por dias", Toast.LENGTH_LONG).show();
            } else if (page == 1) {
                Toast.makeText(container.getContext(),"Aseo 2", Toast.LENGTH_LONG).show();

            } else if (page == 2){
                Toast.makeText(container.getContext(),"Aseo 3", Toast.LENGTH_LONG).show();

            }else
                Toast.makeText(container.getContext(),"Aseo 4", Toast.LENGTH_LONG).show();


        }
    });
    return view;

}



@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
    mViews.set(position, null);
}


private void bind(Model_Servicios item, View view, Context context) {


    ImageView imageView;
    TextView titulo, descrip;

    imageView = (ImageView)view.findViewById(R.id.img_service);
    titulo =(TextView) view.findViewById(R.id.title_service);
    descrip =(TextView) view.findViewById(R.id.description_service);


    TextView titleTextView = (TextView) view.findViewById(R.id.title_service);
    TextView contentTextView = (TextView) view.findViewById(R.id.description_service);

    titleTextView.setText(item.getNombre());
    contentTextView.setText(item.getDescripcion());


    String url = item.getFoto();


    Glide.with(context)
            .load(url)
            .into(imageView);

}