StringBuilder b = new StringBuilder();
while (myRs.next()) {

    String s = myRs.getString("starting_symbol");
    String val = myRs.getString("value");
    if (b.length() > 0) {
        b.append(',');
    }
    b.append(s + "-> " + val);

}
output.setText(b.toString());