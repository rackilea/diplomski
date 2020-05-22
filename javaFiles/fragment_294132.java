holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override public void onClick(View v2) {
        final TextView textViewName = (TextView) v2.findViewWithTag("priceTag"); ;
        final String priceTag = textViewName.getText().toString();
    }
});