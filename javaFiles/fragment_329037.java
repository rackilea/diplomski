mybutton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        dataitem.information = "Hello";
        notifyDataSetChanged();
    }
});