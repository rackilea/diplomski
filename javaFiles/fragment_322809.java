public class MyCustomListAdapter extends ArrayAdapter<String> {

    private ArrayList<String> yourArray;

    public MyCustomListAdapter(Context ctx, ArrayList<String> yourArray){
        super(ctx, R.layout.my_custom_list_item, yourArray);
        this.yourArray = yourArray;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Re-use rows to save battery
        View row;
        if (convertView == null) {
            //We inflate our custom view for the ListView item
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(
                    R.layout.my_custom_list_item, null);
        } else {
            row = convertView;
        }

        //Get the current item of the array
        String arrayItem = yourArray.get(position);
        //Get the text view in the layout of which we want to display the value
        TextView tvListItem = (TextView) row.findViewById(R.id.tv_list_item);
        //Set the text
        tvListItem.setText(arrayItem);
        //Return the row to the ListView
        return row;
    }
}