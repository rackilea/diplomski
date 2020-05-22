class YourActivityGROUP extends ActivityGroup{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);

          //you van get the local activitymanager to start the new activity

          View view = getLocalActivityManager()
                                    .startActivity("ReferenceName", new
          Intent(this,YourActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                                    .getDecorView();
           this.setContentView(view);

       }
    }