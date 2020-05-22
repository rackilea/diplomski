@Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.list_view_row_item, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.itemText);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.checkBox);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checklistItems.get(position).setValue(isChecked);
            }
        });

        name.setText(checklistItems.get(position).getName());
        if (checklistItems.get(position).getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        return convertView;
    }