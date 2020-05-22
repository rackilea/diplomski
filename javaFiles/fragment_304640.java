public class MySimpleAdapter extends ArrayAdapter<HashMap<String, String>> {

    List<HashMap<String, String>> listItems;

    public MySimpleAdapter(Context context, int resource,
            int textViewResourceId, List<HashMap<String, String>> objects) {
        super(context, resource, textViewResourceId, objects);
        listItems = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        if(convertView == null) {
                  LayoutInflater inflator = (LayoutInflater)  getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.list_item, null);
        }

          TextView listName = (TextView) convertView.findViewById(R.id.listName);

        listName.setText(listItems.get(position).get(TAG_NAME));
        return convertView;
    }

}