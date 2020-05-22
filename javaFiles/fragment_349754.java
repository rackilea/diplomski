public class MyAdapter extends BaseAdapter
    {   
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return contactList.size();
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View row=null;
            row=View.inflate(AndroidJSONParsingActivity .this, R.layout.list_item, null);

            TextView lblName = (TextView)row. findViewById(R.id.name);
            TextView lblCost = (TextView)row. findViewById(R.id.email);
            TextView lblDesc = (TextView)row. findViewById(R.id.mobile);

            lblName.setText(contactList.get(position));
            return row;
        }
    }