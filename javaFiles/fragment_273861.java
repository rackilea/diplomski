private SparseArray<String> values = new SparseArray<>();
@Override
public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_row, null);
            holder = new ViewHolder();
            holder.saveName = (Button) convertView.findViewById(R.id.saveName);
            holder.nameField = (EditText) convertView.findViewById(R.id.nameField);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        //Button That saves what the user entered in the nameField to the String variable
        holder.saveName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  values.put(position,nameField.getText().toString());
            }
        });

        //Just to check whether the value is saved when I recycle listview when scrolling
        Log.d("test", values.get(position,"null"));
        //It logs an empty string. The value from the editext was not saved! 
}

static class ViewHolder {
        EditText nameField;
        Button saveName;
        String hidden_value = "";
}