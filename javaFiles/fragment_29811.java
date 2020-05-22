WebMarkupContainer hiddenPanel = // create your panel
hiddenPanel.setOutMarkupPlaceHolderTag(true);
hiddenPanel.setVisible(false)
...
AjaxFallbackLink myLink = new AjaxFallbackLink ("myLink") {

  public void onClick(AjaxRequestTarget target) {
    hiddenPanel.setVisible(true);
    target.addComponent(hiddenPanel);
  }
};