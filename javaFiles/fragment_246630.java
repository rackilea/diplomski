// only initialize the waitingList once here, and repopulate it in loadReservations
List<ListItemData> waitingList = new ArrayList<ListItemData>();

// only create the arrayAdapter once
arrayAdapter = new ArrayAdapter<ListItemData>(getApplicationContext(),
                   android.R.layout.simple_list_item_1,
                   waitingList) {
                   @Override
                   public View getView(int position, View convertView, ViewGroup parent) {

                       View view = super.getView(position, convertView, parent);
                       TextView text = (TextView) view.findViewById(android.R.id.text1);

                       ListItemData data = getItem(position);

                       //TODO: now you have access to all the data!

                       if (data.noSms)
                       {
                           text.setTextColor(Color.RED);
                       }

                       return view;
                   }
               };

lv.setAdapter(arrayAdapter);