StringBuilder msg = new StringBuilder():
Label label = new Label();
for (int i = 0; i < 10; i++) {
    msg.append(Integer.toString(i));
    msg.append(",\n");  //this is the new line you need
}
label.setText(msg.toString());