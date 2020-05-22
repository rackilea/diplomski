// Assuming getSkin() and ioTable are defined elsewhere and ioTable is final
TextButton clearButton = new TextButton("Clear", getSkin());
clearButton.addListener(new EventListener() {
  @Override
  public boolean handle(Event event) {
    for(Actor potentialField : table.getChildren()) {
      if(potentialField instanceof TextField) {
        ((TextField)potentialField).setText("");
      }
    }
    return true;
  }
});
// Add clearButton to your dialog