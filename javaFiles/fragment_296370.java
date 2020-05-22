mCallback = new OnItemRemovedListener() {
        @Override
        public void itemRemoved(int position) {
            mItemList.remove(position);
            notifyDataSetChanged();
        }
    };