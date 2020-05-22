@Override
public View getView(int position, View row, ViewGroup parent) {
    final int listItemPosition = position;
    ImageView img = (ImageView)row.findViewById(R.id.image1);

    img.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
            // Change icon here

            // If you'd like to delete item use the code below
            // List.remove(listItemPosition);
            // Adapter.this.notifyDataSetChanged();
        }
    });
}