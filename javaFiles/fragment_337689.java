SimpleAdapter k=new SimpleAdapter(
                    getActivity(), 
                    usersList, 
                    R.layout.sipuser_list_item,
                    new String[] { TAG_USERNAME, TAG_ADDR, TAG_STATE },
                    new int[] { R.id.username, R.id.addr, R.id.state}
            )
    { 
        @Override 
        public View getView (int position, View convertView, ViewGroup parent)
        { 
            View view = super.getView(position, convertView, parent);

             Button btn=(Button)v.findViewById(R.id.sipuser_list_item);
             btn.setOnClickListener(new OnClickListener() {

                @Override 
                public void onClick(View v) {
                    // click of the button
                } 
            }); 
            return view;
        } 

    };