class MySpinnerAdapter extends ArrayAdapter<String>
{
    MySpinnerAdapter(int dropDownResource, String[] choices)
    {
        super(MainActivity.this, dropDownResource, choices);
    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        if (row == null)
            row = super.getView(position, convertView, parent);
        if (parent.getWidth() > 0)
        {
            TextView label = (TextView) row.findViewById(android.R.id.text1);
            label.setTextSize(TypedValue.COMPLEX_UNIT_PX, SetTextSize(label.getText().toString(), parent.getWidth() - label.getPaddingLeft() - label.getPaddingRight(), (int) fieldHeight - label.getPaddingTop() - label.getPaddingBottom()));
            label.setPadding(label.getPaddingLeft(), 0, 0, 0);
        }
        return(row);
    }
}