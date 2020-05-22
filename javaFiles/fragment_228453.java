//you can use addItem all for adding data in array
    public void addItem(ClassName item) {
            mList.add(item);
            notifyItemInserted(mList.size() - 1);
        }

//delete all for deleting the whole list of data
        public void deleteAll() {
            mList.clear();
            notifyDataSetChanged();
        }

//For deleting a perticular item from data
        public void deleteItem(int index) {
            mList.remove(index);
            notifyItemRemoved(index);

        }

//For adding the whole set of array
        public void addAllItems(List<ClassName> items) {
            mList.addAll(items);
            notifyDataSetChanged();
        }

//For Updating a single item  
        public void updateItem(int index, ClassName item) {
            mList.set(index, item);
            notifyItemChanged(index);
        }