private class ChildViewHolder {
    public TextView childTitle;
    public EditText et;

    public ChildViewHolder(View itemView, int groupPosition, int childPosition) {
        super(itemView);
        childTitle = itemView.findViewById(R.id.textViewChild);
        et = itemView.findViewById(R.id.productCount);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence != null){
                      groupItem.get(groupPosition).getArrayList().get(childPosition).setValue(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });
    }

}