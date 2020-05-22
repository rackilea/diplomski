public class CustomAdapter extends ArrayAdapter<Data> implements Spinner
                                                      .OnItemSelectedListener {
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(android.R.layout.simple_spinner_item,
                        parent, false);
        Data data = getItem(position);
        // Do something with data and view here
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, 
                                                int position, long arg4) {
        Data data = getItem(position);
        // Do something with data here
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}