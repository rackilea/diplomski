int setCount = 0;
while (set.next()) {
  setCount++;
  System.out.print(set.getString("dept_name"));
  txtName.setText(set.getString("dept_name"));
  txtDes.setText(set.getString("dept_desc"));
}
if (setCount == 0) {
  // show a warning to the user that the result set was empty
}