public View getView(int position, View convertView, final ViewGroup parent) {
    View vi = convertView;
    if (convertView == null)
        vi = inflater.inflate(R.layout.list_equipment_search, null);
    enter code here
    TextView serialno = (TextView) vi.findViewById(R.id.txtSerialNo); // Serial No
    TextView unitno = (TextView) vi.findViewById(R.id.txtUnitNo);

 CheckBox checkbox = (CheckBox) row.findViewById(R.id.chkEquipment);
        checkbox.setTag(new Integer(position));
        checkbox.setOnCheckedChangeListener(null);

            if (checkBoxState[position])
                checkbox.setChecked(true);
            else
                checkbox.setChecked(false);



        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Integer pos = (Integer) buttonView.getTag();
                if (isChecked) {

                    checkBoxState[pos.intValue()] = true;
                } else {
                    checkBoxState[pos.intValue()] = false;


                }
            }
        });