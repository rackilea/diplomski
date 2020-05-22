@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
    final Coupons coupons = coupons2.get(position);

    viewHolder.imageView.setImageResource(coupons.getLogo());
    viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //TODO: you can use 'coupons' and 'position' declared as final here
            String i = coupons.getTAG();
        }
    });
}