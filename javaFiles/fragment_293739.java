public class ItemAdapter extends ArrayAdapter<SizeCount> {
    private static final String LOG_TAG = "MemoListAdapter";

    private Collection<SizeCount> list;

    public ItemAdapter(Context context, List<SizeCount> list) {
        super(context, 0, list);
        this.list = list;
    }

    public Collection<SizeCount> getList() {
        return list;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SizeCount item = getItem(position);
        if (item == null) return convertView;

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.entry_size_count, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tbCount = (EditText) convertView.findViewById(R.id.tbCount);
            viewHolder.tvSize = (TextView) convertView.findViewById(R.id.tvSize);
            viewHolder.btAdd = convertView.findViewById(R.id.btAdd);
            viewHolder.btAdd.setOnTouchListener(new View.OnTouchListener() {
                private Handler mHandler = new Handler();

                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            mHandler.postDelayed(mAction, 500);
                            break;
                        case MotionEvent.ACTION_UP:
                            mHandler.removeCallbacks(mAction);
                            break;
                    }
                    return false;
                }

                Runnable mAction = new Runnable() {
                    @Override
                    public void run() {
                        float currentCount = item.getCount();
                        float nextCount = currentCount + 1;
                        item.setModified(true);

                        // update SizeCount value
                        item.setCount(nextCount);

                        // set value to tbCount
                        viewHolder.tbCount.setText(String.valueOf(item.getCount()));

                        // this will cause the MotionEvent.ACTION_UP fail
                        // notifyDataSetChanged();

                        mHandler.postDelayed(this, 500);
                    }
                };

            });

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvSize.setFocusable(false);
        viewHolder.tvSize.setText(item.getArticles().getSize());
        viewHolder.tbCount.setText(item.getCount() + "");
        return convertView;
    }

    private class ViewHolder {
        TextView tvSize;

        TextView tbCount;

        Button btAdd;
    }
}