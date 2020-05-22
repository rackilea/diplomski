myService.getHtmlSnippet(myParam, new AsyncCallback<String>() {

  @Override
  public void onSuccess(String result) {
    myParent.add(new HTML(result));
    // or: myElem.setInnerHTML(result);
  }

  @Override
  public void onFailure(Throwable caught) {
    // ...
  }
});