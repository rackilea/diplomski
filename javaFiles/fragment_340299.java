final Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case KEEP_SCREEN_ON_MSG: {
                setKeepScreenOn(msg.arg1 != 0);
            } break;
            case GET_NEW_SURFACE_MSG: {
                handleGetNewSurface();
            } break;
            case UPDATE_WINDOW_MSG: {
                updateWindow(false, false);
            } break;
        }
    }
};