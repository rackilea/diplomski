public MyFloatingButton implements View.OnClickListener {

    public MyFloatingButton(Context context, RootActivity activity, View view) {
        this.context = context;
        this.activity = activity;
        this.activityView = view;
        getViews();
        initCircleSelector();
        activityView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        // handle click event
    }

    .....

}