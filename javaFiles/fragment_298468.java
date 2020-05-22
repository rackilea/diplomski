LayoutInflater inflater = (LayoutInflater) collection.getContext()
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

View rootView = inflater.inflate(R.layout.your_layout, null);

rootView.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        //do the click thing
    }
});

container.addView(rootView);
return rootView;