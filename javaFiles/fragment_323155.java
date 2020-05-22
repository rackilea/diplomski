if (!TextUtils.isEmpty(homeworkItem)) {
        homeworkItems.add(homeworkItem);
homeworkListAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, homeworkItems);
homeworkListView.setAdapter(homeworkListAdapter);
    }