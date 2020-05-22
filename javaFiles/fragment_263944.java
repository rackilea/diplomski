public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView textView;
    private int itemPosition;
    private Context mContext;

    public MyViewHolder(@NonNull View itemView, Context context) {
        super(itemView);

        itemView.setOnClickListener(this);

        mContext = context;
        textView = itemView.findViewById(R.id.textView_Time);
    }

    void bind(String timeText)
    {
        textView.setText(timeText);
    }

    void setItemPosition(int position)
    {
        itemPosition = position;
    }

    @Override
    public void onClick(View v) {

        Toast.makeText(mContext, "You clicked item number: " + itemPosition , Toast.LENGTH_SHORT).show();

    }
}