class ExpandableListAdapter : BaseExpandableListAdapter { 
    TextView txtListChild;
    ...
    public override View GetChildView(int groupPosition, int childPosition, bool isLastChild, View convertView, ViewGroup parent)
    {
       ...
       txtListChild = (TextView)convertView.FindViewById(Resource.Id.lListItem);
       ...
    }
    txtListChild.Text = childText;
    return convertView;
}