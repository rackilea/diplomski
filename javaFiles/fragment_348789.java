@OnClick(R.id.back) void onXButtonClick(View v) {
    if(getOnBackButtonClickListener() != null) {
      getOnBackButtonClickListener().onClick(v);
    }
  }

  @OnClick(R.id.x_btn) void onBackButtonClick(View v) {
    if(getOnXButtonClickListener() != null) {
      getOnXButtonClickListener().onClick(v);
    }
  }