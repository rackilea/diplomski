StringBuilder sb = new StringBuilder();
for (int i=0; i<queryArray.length(); i++) {
    // chain each string, separated with a new line
    sb.append(queryArray.getString(i) + "\n");
}
// display the content on textview
tv1.setText(sb.toString());