public RecyclerViewAdapter(ArrayList<RowData> data) {
        mData = data;

        //find out the maximum time the timer
        long maxTime = System.currentTimeMillis();
        for (RowData item : mData) {
            maxTime = Math.max(maxTime, item.endTime);
        }

        //set the timer which will refresh the data every 1 second.
        new CountDownTimer(maxTime - System.currentTimeMillis(), 1000) {
            @Override
            public void onTick(long l) {
                for (int i = 0, dataLength = mData.size(); i < dataLength; i++) {
                    RowData item = mData.get(i);
                    item.timeRemaining -= 1000;
                }

                //remove the expired items
                Iterator<RowData> dataIterator = mData.iterator();
                while (dataIterator.hasNext()) {
                    RowData rd = dataIterator.next();
                    if (rd.timeRemaining <= 0) dataIterator.remove();
                }
                notifyDataSetChanged();
            }

            @Override
            public void onFinish() {
                mData.clear();
                notifyDataSetChanged();
            }
        }.start();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(android.R.layout.simple_list_item_2, parent, false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RowData rowData = mData.get(position);
        holder.titleTv.setText(rowData.title);
        holder.remainingTimeTv.setText(millToMins(rowData.timeRemaining) + " mins remaining");
    }

    private String millToMins(long millisec) {
        return millisec / (60000) + ":" + (int) (millisec/1000) % (60);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView remainingTimeTv;
        private TextView titleTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            remainingTimeTv = (TextView) itemView.findViewById(android.R.id.text2);
            titleTv = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

}