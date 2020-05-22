public static class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

    public TextView txtViewTitle;
    public ImageView imgViewIcon;
    public IMyViewHolderClicks mListener;

    public ViewHolder(View itemLayoutView, IMyViewHolderClicks listener) {
        super(itemLayoutView);
        mListener = listener;
        txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.item_title);
        imgViewIcon = (ImageView) itemLayoutView.findViewById(R.id.item_icon);
        imgViewIcon.setOnClickListener(this);
        itemLayoutView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView){
           mListener.onTomato((ImageView)v);
        } else {
           mListener.onPotato(v);
        }
    }

    public static interface IMyViewHolderClicks {
        public void onPotato(View caller);
        public void onTomato(ImageView callerImage);
    }

}