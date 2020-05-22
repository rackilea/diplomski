@NonNull
@Override
public View getView(int position, View convertView, ViewGroup parent)
{
    View listItemView = convertView;
    if(listItemView == null)
    {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
    }

    EarthQuake currentEarthQuakeObj = getItem(position);

    TextView magText = (TextView) listItemView.findViewById(R.id.magnitude);
    magText.setText(Double.toString(currentEarthQuakeObj.getMagnitude()));

    return listItemView;
}