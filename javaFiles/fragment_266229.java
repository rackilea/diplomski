ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView betidtextbox = (TextView) view.findViewById(R.id.gid);
            String betid = betidtextbox.getText().toString();
        }
    });