//...

View rootView = inflater.inflate(R.layout.fragment_main, container, false);
Button buttonClick = (Button)rootView.findViewById(R.id.button);
buttonClick.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        onButtonClick((Button) view);
    }
});