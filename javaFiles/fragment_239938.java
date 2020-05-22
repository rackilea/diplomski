final boolean buttonSwitch;
myButton.addListener(new ClickListener() {
        public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

             myButton.setStyle(buttonSwitch?style1:style2);
             buttonSwitch=!buttonSwitch;   
        }
    });