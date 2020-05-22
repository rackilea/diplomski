@OnClick(R.id.x_btn) void onXButtonClick(View v) {
    if(getOnBackButtonClickListener() != null) {
      getOnBackButtonClickListener().onClick(v);
    }
  }

  @OnClick(R.id.back) void onBackButtonClick(View v) {
    if(getOnXButtonClickListener() != null) {
      getOnXButtonClickListener().onClick(v);
    }
  }