// Update the adapter to use string arrays instead of just strings
public class StableArrayAdapter extends ArrayAdapter<String[]> {

    final int INVALID_ID = -1;
    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

    // Save these references to the layout and string data
    int mRowLayout;
    List<String[]> mStrings;

    // Constructor should accept string arrays
    public StableArrayAdapter(Context context, int rowLayout, List<String[]> objects) {

        super(context, rowLayout, objects);

        // Change this so your string array list can be indexed
        for (int i = 0; i < objects.size(); ++i) {

            // Make sure you are using a unique string for each list row
            // String[0] is just an example
            String[] stringArray = objects.get(i);
            String uniqueString = stringArray[0]; 

            mIdMap.put(uniqueString, i);
        }

        mRowLayout = rowLayout;
        mStrings = objects;
    }

    ...

    // Populate your layout text views with data from your string array
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(getContext()).inflate(mRowLayout, null);

        TextView tvAddress = (TextView)convertView.findViewById(R.id.item_adressView);
        TextView tvZipCode = (TextView)convertView.findViewById(R.id.item_zipcodePlaceView);
        TextView tvCompany = (TextView)convertView.findViewById(R.id.item_companyView);
        TextView tvDriveType = (TextView)convertView.findViewById(R.id.item_driveTypeView);

        tvAddress.setText(mStrings.get(position)[0]);
        tvZipCode.setText(mStrings.get(position)[1]);
        tvCompany.setText(mStrings.get(position)[2]);
        tvDriveType.setText(mStrings.get(position)[3]);

        return convertView;
    }
}