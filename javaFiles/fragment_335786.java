@Override
  public void onStart() {
    super.onStart();

    getView().setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Log.e(getClass().getSimpleName(), "got here");
      }
    });
  }