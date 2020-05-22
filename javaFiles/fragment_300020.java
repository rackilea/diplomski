@Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(ImageActivity.this, "You pressed at position " + position, Toast.LENGTH_SHORT).show();

        delete = view.findViewById(R.id.delete); //select the right image

        delete.setClickable(true);
        delete.setVisibility(View.VISIBLE);
        return true;
    }
});