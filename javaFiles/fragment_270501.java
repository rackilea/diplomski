you go through this..



            sendData = (EditText) findViewById(R.id.message);
            sendData.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == 
                                      KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press
                adapter.add(new OneComment(false,  
                                    sendData.getText().toString()));
                sendData.setText("");
                return true;
            }
            return false;
           }
           });