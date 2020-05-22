public class ListViewAdapter extends BaseAdapter
{
    private List<FruitNames> TempList;
    private int layoutResId;

    public ListViewAdapter(List<FruitNames> listValue, int layoutResId)
    {
        this.TempList = listValue;
        this.layoutResId = layoutResId;
    }

    // other methods like before...

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewItem viewItem = null;

        if(convertView == null) {
            viewItem = new ViewItem();
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(layoutResId, null);
            viewItem.NazwaInwentaryzacji = (TextView)convertView.findViewById(R.id.NazwaInwentaryzacji);
            viewItem.DataInwentaryzacji = (TextView)convertView.findViewById(R.id.DataInwentaryzacji);
            viewItem.NrInwentaryzacji = (TextView)convertView.findViewById(R.id.NrInwentaryzacji);
            convertView.setTag(viewItem);
        }
        else{
            viewItem = (ViewItem) convertView.getTag();
        }
        viewItem.NazwaInwentaryzacji.setText(TempList.get(position).NazwaInwentaryzacji);
        viewItem.DataInwentaryzacji.setText('['+TempList.get(position).DataInwentaryzacji+']');
        viewItem.NrInwentaryzacji.setText(TempList.get(position).NrInwentaryzacji+'.');
        return convertView;
    }
}