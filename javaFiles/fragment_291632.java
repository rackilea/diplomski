class QueryAdapter extends ParseQueryAdapter {
    public QueryAdapter(Context context, ParseQueryAdapter.QueryFactory<T> queryFactory) {
        super(context, queryFactory, 0);
    }

    @Override
    public getItemView(ParseObject object, View v, ViewGroup parent) {
        if (null == v) {
            v = View.inflate(getContext(), R.layout.your_layout, null);
        }
        TextView name = (TextView) v.findViewById(R.id.text_view_id);
        ImageView image = (ImageView) v.findViewById(R.id.image_view_id);
        ParseUser fromUser = object.getParseUser("fromUser");
        name.setText(fromUser.getString("username");
        !-- Load your image here
    }
}