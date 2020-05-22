@Override
  public void goBack() {
    WebBackForwardList temp = copyBackForwardList();
    for (int i=0; i<temp.getSize(); i++) {
      WebHistoryItem item = temp.getItemAtIndex(i);
      // do whatever you want here...
    }

    // do whatever you want here...
    super.goBack();
  }