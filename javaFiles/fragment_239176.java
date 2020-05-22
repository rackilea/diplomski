View.OnClickListener getPersonClickListener(final int position) {
    return new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(mContext instanceof RecyclerViewActivity){
                ((RecyclerViewActivity)mContext).onClickChangeActivity();
            }
        }
    };