public void onTextChanged(CharSequence s,int start, int before,int count)
        {
            ListView lv = getListView();
            ListAdapter adapter = (ListAdapter) lv.getAdapter();
            lv.setTextFilterEnabled(true);
            adapter.getFilter().filter(s.toString());
        }