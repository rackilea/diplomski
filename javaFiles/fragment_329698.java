try {
    firstnameBox.setText(user.getString("firstname"));
    lastnameBox.setText(user.getString("lastname"));
    departmentBox.setText(user.getString("department"));
    officeBox.setText(user.getString("office"));
    emailBox.setText(user.getString("email"));
    phonenoBox.setText(user.getString("phoneno"));
    passwordBox.setText(user.getString("password"));
    statusBox.setText(user.getString("status"));
} catch(JSONException e) {
  // process your exception
}