private Handler handler = new Handler();

private Runnable runnable = new Runnable() {
    @Override
    public void run() {
       Log.d("mId", String.valueOf(curHolder.container.getId()));
        curHolder.cardView.setVisibility(View.GONE);