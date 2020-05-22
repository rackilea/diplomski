@Override
public  recylcerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    //create a new view
    final CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_main, parent, false);
    cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(listener != null){
                    Log.v("hitsOnClick", "It has been hit");
                    listener.onClick((int)cardView.getTag());

                }
            }
        });
    return new ViewHolder(cardView);
}

@Override
public void onBindViewHolder(ViewHolder holder, final int position){
    //set the values inside the given view

    Drawable drawable = holder.cardView.getResources().getDrawable(imageIds[position]);
    holder.imageView.setImageDrawable(drawable);
    holder.imageView.setContentDescription(nameArray[position]);
    holder.textView.setText(nameArray[position]);

    holder.cardView.setTag(position);
}