@Override
  protected void onResume() {
    super.onResume();
    EventBus.getInstance().register(this);
  }

  @Override
  protected void onPause() {
    EventBus.getInstance().unregister(this);
    super.onPause();
  }