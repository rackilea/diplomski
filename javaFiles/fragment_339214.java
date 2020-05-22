checkDistance.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        flag = checkDistance.isChecked();
        adapter.notifyDataSetChanged();
    }
});