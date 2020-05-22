public class MyAdapter extends ArrayAdapter<Contact> {
        Context context;
        public MyAdapter(Context context, ArrayList<Contact> users) {
            super(context, 0, users);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Contact user = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.listviewadapter, parent, false);
            }
            TextView name = convertView.findViewById(R.id.name);
            TextView num = convertView.findViewById(R.id.num);
            // Populate the data into the template view using the data object

            name.setText(user.name);
            num.setText(user.phone_number);
            // can set click on name or num
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position + "position clicked", Toast.LENGTH_SHORT).show();
                }
            });
            // can set click on full list item
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, position + "position clicked", Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
        }
    }