listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> a, View v, int position, long id) {
ContactItem contactData = (ContactItem) listView.getItemAtPosition(position);
Intent intent = new Intent(getActivity(), ContactDetail.class);
               intent.putExtra("DATA_KEY", contactData);
               startActivity(intent);
            }
        });