public CloseKitchen extends AbstractAction {

  private Cook cook;

  public CloseKitchen(Cook cook) {
    super("Close Kitchen");
    this.cook = cook;
  }

  public void actionPerformed(ActionEvent e) {
    cook.goHome();
  }
}