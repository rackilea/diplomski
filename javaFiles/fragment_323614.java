LinearLayout parent;
LinearLayout wrapper;

private void createView() {

    parent = (LinearLayout) inflater.inflate(R.layout.parent, (ViewGroup) findViewById(R.id.ly_parent));
    wrapper = parent.findViewById(R.id.ly_wrapper);

    addNewChild();
}

private void addNewChild(){
    //update this below line
    LinearLayout child = (LinearLayout) inflater.inflate(R.layout.child,null,false);

    ImageView imageView = child.findViewById(R.id.iv_image);
    wrapper.addView(child);

    imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addNewChild();

        }
    });
}