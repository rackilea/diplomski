btnAjouter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        item.setCount( item.getCount() + 1 ); //declare a method to set value
        notifyDataSetChanged();
    }
});