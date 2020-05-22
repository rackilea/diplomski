TextArea area = new TextArea();
             area.addKeyDownHandler(new KeyDownHandler() {

                @Override
                public void onKeyDown(KeyDownEvent event) {
                    if(event.getNativeKeyCode()==13 ||....){//Add remaining key codes which you dont want.For example i added enter key which keycode is 13.Remove that and add your key codes there. 
                        event.preventDefault();
                 }  
                }
            });