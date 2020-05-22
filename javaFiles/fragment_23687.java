btnSelected.setTag(currentRowIndex); // attach Integer data to the view
btnSelected.setOnClickListener(new OnClickListener() {
    @Override
    public void onClick(View v) {
        int rowIndex = (Integer)v.getTag();
        // do something with rowIndex
    }
});