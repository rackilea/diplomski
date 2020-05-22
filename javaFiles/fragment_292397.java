public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.v("log_tag", "char : " + event.getUnicodeChar());

        if (event.getUnicodeChar() != 0) {
            int i = event.getUnicodeChar();
            ch += new Character((char) i).toString();
        }
        if (keyCode == KeyEvent.KEYCODE_DEL && ch.length() > 0) {
            ch = ch.substring(0, ch.length() - 1);
        }
        value.setText(ch);
        return super.onKeyDown(keyCode, event);
    }