public View getView(final int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = ((Activity)this.context).getLayoutInflater();
    convertView = inflater.inflate(R.layout.row_with_cb, parent, false);
    TextView name = (TextView)convertView.findViewById(R.id.row_with_cb_Txt);
    CheckBox cb = (CheckBox)convertView.findViewById(R.id.row_with_cb_ChkBox);

    arrCheckBoxes.add(cb); // THIS ARRAY ALWAYS REMAINS UPDATED INSIDE ONCLICKLISTENER

    // Create a onClickListener when a checkbox is selected
    cb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CheckBox cb = (CheckBox) v;
            rowItems[position].setCB(cb.isChecked());

            if(cb.isChecked()) {
                for(int iCnt = 0; iCnt < arrCheckBoxes.size(); iCnt++) {
                    if (rowItems[iCnt].isCBChecked() && !rowItems[iCnt].getDeviceAddress().equals(rowItems[position].getDeviceAddress())) {
                        if (rowItems[iCnt].getDeviceMajorClass() == rowItems[position].getDeviceMajorClass()) {
                            arrCheckBoxes.get(iCnt).setChecked(false); // THIS IS WHERE ANOTHER CHECKBOX GETS UNCHECKED IF THE CONDITION GETS SATISFIED
                            rowItems[iCnt].setCB(false);
                            notifyDataSetChanged();
                        }
                    }
                }
            }
        }
    });