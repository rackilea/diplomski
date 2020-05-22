editText.setOnKeyListener(new OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                switch(keyCode) {
    case KeyEvent.KEYCODE_ENTER:
     Intent intent = new Intent(SignIn.this, List_Of_Songs.class);
     startActivity(intent);
            break;

    default:
            return false;
    }

    return true;

            }
        });