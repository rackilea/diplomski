class pdHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
      if(pd != null)
      {
      pd.dismiss();
      pd = null;
      }
    }