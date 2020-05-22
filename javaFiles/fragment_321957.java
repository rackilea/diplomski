@Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(pointer =< 2){
            touches.get(pointer).touchX = screenX;
            touches.get(pointer).touchY = screenY;
            touches.get(pointer).touched = true;
        }
        return true;
    }