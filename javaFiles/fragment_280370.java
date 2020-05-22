gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
        @Override
        public int getSpanSize(int position) {

            //depanding upon the type of data  set the span-size if it is header take the whole space in the row
            //also check the orientation and set the span-size
            if (mAdapter.getItemViewType(position) == Adapter.ITEM_VIEW_TYPE_HEADER) {
                    return 2;
                }
            }
            // if the type is item type keep the span-size as normal which is one
            if (mAdapter.getItemViewType(position) == Adapter.ITEM_VIEW_TYPE_ITEM) {
                return 1;
            }
            return -1;
        }
    });