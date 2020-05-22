public interface OnItemClickListener {
    public void onItemClick(View v, int pos);
}

public MainMenuAdapter(Context context, String[] dataSet, Boolean isNative, OnItemClickListener mOnItemClickListener){
    this.context = context;
    this.dataSet = dataSet;
    this.isNative = isNative;
    this.mOnItemClickListener = mOnItemClickListener;
}