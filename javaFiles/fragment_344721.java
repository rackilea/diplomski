Gdx.input.setInputProcessor(new InputAdapter(){
        @Override
        public boolean keyDown(int keycode) {

            if (keycode==Input.Keys.BACK){
                 platformService.moveToStack();
            }

            return super.keyDown(keycode);
        }
    });