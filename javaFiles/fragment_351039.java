@Override
public View getDropDownView(int position, View convertView, ViewGroup parent)
{
    View view = super.getDropDownView(position, convertView, parent);
    TextView textView = (TextView) view.findViewById(android.R.id.text1);
    textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, maxTextSize);
    textView.setPadding(paddingLeft + paddingLeftExtra, paddingTop + paddingTopExtra, paddingLeft + paddingLeftExtra, paddingTop + paddingTopExtra);
    return view;
}