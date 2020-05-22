int count = listView.getCount();
for (int i = 0; i < count; i++) {
    listView.post(new Runnable() {
        @Override
        public void run() {
            listView.smoothScrollToPosition(i);
        }
    }); 
}
// Once the method gets to here, i == count and we're at the last position
// So you can use some logic to scroll back to the top e.g. 
// listView.smoothScrollToPosition(0)