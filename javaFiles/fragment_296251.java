if (adapter == null) {
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, feed_XMLs);
        setListAdapter(adapter);
        }

        else {
             adapter.notifyDataSetChanged();
        }