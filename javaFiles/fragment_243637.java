editText.setOnKeyListener(new View.OnKeyListener() {
    public boolean onKey(View v, int keyCode, KeyEvent event) {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && 
                (keyCode == KeyEvent.KEYCODE_ENTER)) {

                // Perform your calculation on key press and update edit text
                editText.setText(String.valueOf(doCalc(
                    Double.valueOf(editText.getText().toString())));

                return true;
            }
            return false;
        }
    });