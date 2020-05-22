public static void getData(String name) {
  if (name == null) {
    renderText("Without Parameter");
  } else {
    renderText("With Parameter name = " + name);
  }
}