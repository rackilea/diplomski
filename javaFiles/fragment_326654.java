public class AdapterDownload extends ArrayAdapter<StructDownload> {

public AdapterDownload(ArrayList<StructDownload> array) {
    super(G.context, R.layout.item_layout, array);
}


private static class ViewHolder {

    public ViewHolder(View view)
    {

    }


    public void fill(final ArrayAdapter<StructDownload> adapter, final StructDownload item, final int position)
    {

    }
}


@Override
public View getView(int position, View convertView, ViewGroup parent) {

}