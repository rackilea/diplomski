numberText.setOnKeyListener(new OnKeyListener() {                 
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            //You can identify which key pressed buy checking keyCode value with KeyEvent.KEYCODE_
             if(keyCode == KeyEvent.KEYCODE_DEL){  
                 //this is for backspace
                 String text = numberText.getText().toString();
                 if(text.equals("+1")) 
                   return false; 
             }      
        }
    });