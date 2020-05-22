public void setData(final int position) {
    eventName.setText(String.format("", position));
    theLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (position == 1){
                addItem("");
            }else {
                removeItem(position);
            }
        }
}