listView.setOnItemLongClickListener(new OnItemLongClickListener() {

        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                int pos, long id) {
            // TODO Auto-generated method stub
             myClip = ClipData.newPlainText("copyfav", copyfav);
             myClipboard.setPrimaryClip(myClip);

            return true;
        }
    });