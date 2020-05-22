list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //postItem(s) is Object where your list is populated with
            postItem= (PostItem) parent.getItemAtPosition(position);

            Intent contentIntent = new Intent(MainActivity.this, ContentPage.class);
            Bundle bundle = new Bundle();
            bundle.putString("topicName", postItem.getTopic());
            bundle.putString("content", postItem.getContent());
            bundle.putString("dateTime", postItem.currentDateTimeString());
            contentIntent.putExtras(bundle);
            startActivity(contentIntent);
        }
    });