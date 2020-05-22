//!! make this boolean
public boolean check() {
  if (jTextField1.getText().trim().isEmpty()) {
     return false;
  }
  if (jPasswordField1.getPassword().length == 0) {
     return false;
  }
  return true;
}