public void addRegisterListener(RegisterListener listener) {
  //add listener to some collection.
}

//Call this method on Submit button press
protected void fireRegistered() {
  //iterate over collection of listeners and on each do:
    listener.userRegistered(user);
}