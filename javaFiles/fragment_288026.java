public View getView(int position, View myView, ViewGroup parent) {
    LayoutInflater vi = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    myView = vi.inflate(R.layout.football_adapter_item, null);


    FootballModel fm = new FootballModel();
    fm = getItem(position);

    //TODO TextViews
    //------------------------------------------//
    TextView text = myView.findViewByID(...);
    text.setText(...);
    //------------------------------------------//

    return myView;

}