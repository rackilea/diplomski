public static abstract class DecorerAdapter extends BaseAdapter {

            public int DECORER_ITEM_TYPE;
            private final BaseAdapter mInnerAdapter;
            private final int mRepeatAfterEvery;
            private int mCount;

            public DecorerAdapter(BaseAdapter innerAdapter, int repeatAfterEvery) {
                mInnerAdapter = innerAdapter;
                mRepeatAfterEvery = repeatAfterEvery;
                mInnerAdapter.registerDataSetObserver(new DataSetObserver() {
                    @Override
                    public void onChanged() {
                        notifyDataSetChanged();
                    }

                    @Override
                    public void onInvalidated() {
                        notifyDataSetInvalidated();
                    }
                });
                setupAdapter();
            }

            @Override
            public void notifyDataSetChanged() {
                setupAdapter();
                super.notifyDataSetChanged();
            }

            private void setupAdapter(){
                mCount = mInnerAdapter.getCount();
                mCount += (mCount  + mRepeatAfterEvery - 2) / (mRepeatAfterEvery - 1);
                DECORER_ITEM_TYPE = mInnerAdapter.getViewTypeCount();
            }

            @Override
            public int getCount() {
                return mCount;
            }

            @Override
            public Object getItem(int position) {
                if(position % mRepeatAfterEvery == 0)
                    return null;
                return mInnerAdapter.getItem(calculateInnerPosition(position));
            }

            private int calculateInnerPosition(int position) {
                return position - (position  + mRepeatAfterEvery - 1) / mRepeatAfterEvery;
            }

            @Override
            public long getItemId(int position) {
                if(position % mRepeatAfterEvery == 0)
                    return -1;
                return mInnerAdapter.getItemId(calculateInnerPosition(position));
            }

            @Override
            public int getItemViewType(int position) {
                if(position % mRepeatAfterEvery == 0)
                    return DECORER_ITEM_TYPE;
                return mInnerAdapter.getItemViewType(calculateInnerPosition(position));
            }

            @Override
            public boolean hasStableIds() {
                return mInnerAdapter.hasStableIds();
            }

            @Override
            public int getViewTypeCount() {
                return mInnerAdapter.getViewTypeCount() + 1;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if(position % mRepeatAfterEvery == 0)
                    return getDecorerView((position  + mRepeatAfterEvery - 1) / mRepeatAfterEvery, convertView, parent);
                return mInnerAdapter.getView(calculateInnerPosition( position), convertView, parent);
            }

            public abstract View getDecorerView(int position, View convertView, ViewGroup parent);
        }