final SimpleExpandableListAdapter sa = new SimpleExpandableListAdapter(/*your list of parameters*/)
{
    @Override
    public View getChildView(int groupPosition, int childPosition, 
            boolean isLastChild, View convertView, ViewGroup parent)
    {
        final View itemRenderer = super.getChildView(groupPosition, 
                childPosition, isLastChild, convertView, parent);
        final TextView tv = (TextView)itemRenderer.findViewById(R.id.text);
        if (/*check whether the data at groupPosition:childPosition is correct*/)
            tv.setTextColor(getResources().getColor((R.color.green));
        else
            tv.setTextColor(getResources().getColor((R.color.red));
        return itemRenderer;
    }
};