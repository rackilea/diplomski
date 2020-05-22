// set item state listener
form.setItemStateListener(this);

// check if text field contains invalid string
// then replace it
public void itemStateChanged(Item item) {
    if (item == getTextField()) {
        TextField t = (TextField)item;
        String s = t.getString();
        // + is invalid string
        int pos = s.indexOf("+");
        if (pos != -1) {
            t.setString(s.substring(0, pos) + s.substring(pos + 1));
        }
    }
}