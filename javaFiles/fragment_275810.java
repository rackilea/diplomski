@Override
       public void onCreateContextMenu(ContextMenu menu, View v,
            ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
        adapter = new ListViewAdapter(getActivity(), arraylist);
        Object item = adapter.getItem(info.position);

        menu.setHeaderTitle("Opções");
        menu.add(0, v.getId(), 0, "Like");
        menu.add(1, v.getId(), 0, "Comment");
        menu.add(2, v.getId(), 0, "Favorite");

        }


        @Override   
        public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Like") {
            addLike(item.getItemId());
        } else if (item.getTitle() == "Comment") {

        } else if (item.getTitle() == "Favorite") {
            // code
        } else {
            return false;
        }
        return true;

        }

        public void addLike(int id){

        }