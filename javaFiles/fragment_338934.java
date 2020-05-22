listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChatMessage selectedList = adapter.getItem(position);
                if(selectedList != null) {

                    Intent intent = new Intent(MainActivity.this, MainDetails.class);
                   // long listId = adapter.getItemId(position);

                        intent.putExtra(Constants.KEY_LIST_NAME, selectedList.getName());
                        intent.putExtra(Constants.KEY_LIST_PHONE, selectedList.getPhone());
                        intent.putExtra(Constants.KEY_LIST_EMAIL, selectedList.getEmail());
                        startActivity(intent);
                    }
            }
        });