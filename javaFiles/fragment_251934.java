objItem = new Contacts(this);

this.cur = objItem.getList();
this.startManagingCursor(this.cur);

ListAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cur,
        new String[] { ContactsContract.Contacts.DISPLAY_NAME}, new int[] { android.R.id.text1});

setListAdapter(adapter);