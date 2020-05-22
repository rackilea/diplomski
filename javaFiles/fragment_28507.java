if (UserName != null && !UserName.isEmpty()) {  // Or use your favorite library.
  // The user has entered a value: check that it is valid.
  if (!UserName.matches("[a-zA-Z0-9-~!_#(@).]+")) {
    PopMyError();
  }
}