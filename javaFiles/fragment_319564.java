dialog.addListener(new InputListener() {
        public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
            if (x < 0 || x > dialog.getWidth() || y < 0 || y > dialog.getHeight()){
                dialog.hide();
            }
            return true;
        }
    });