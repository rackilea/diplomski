textBox.addKeyUpHandler(new KeyUpHandler() {
            public void onKeyUp(KeyUpEvent event) {
                if (!Character.isLetter(event.getNativeKeyCode())) {
                    ((TextBox)event.getSource()).cancelKey();
                    customPopup.showRelativeTo(textBox);// your styled PopupPanel
                }
            }
        });