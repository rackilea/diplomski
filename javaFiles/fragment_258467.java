public static RealtimeClockListener clockListenerTest = new RealtimeClockListener() {
    int _4Minutes = 60 * 4;
    int _5Minutes = 60 * 5;
    Dialog dialog4Minutes = null;
    Dialog dialog5Minutes = null;
    public void clockUpdated() {
        synchronized (UiApplication.getEventLock()) {
            UiEngine ui = Ui.getUiEngine();
            if ( DeviceInfo.getIdleTime() < _4Minutes ){
                // Shouldn't be needed - this is just for safety
                if ( dialog4Minutes != null ) {
                    dialog4Minutes.close();
                    dialog4Minutes = null;
                }
            }
            if ( DeviceInfo.getIdleTime() < _5Minutes ){
                // Shouldn't be needed - this is just for safety
                if ( dialog5Minutes != null ) {
                    dialog5Minutes.close();
                    dialog5Minutes = null;
                }
            }
            if ( DeviceInfo.getIdleTime() >= _4Minutes && DeviceInfo.getIdleTime() < _5Minutes ) {
                if ( dialog4Minutes == null ) {
                    // 4 minute Dialog has not been pushed yet
                    dialog4Minutes = new Dialog("Stay Logged In?", new String[] {"SI", "NO"}, new int[]{1,2}, 2, null);
                    ui.pushGlobalScreen(dialog4Minutes, 1,UiEngine.GLOBAL_QUEUE);
                }
            } else if ( DeviceInfo.getIdleTime()>=_5Minutes ) {
                if ( dialog5Minutes == null ) {
                    // 5 minute Dialog has not been pushed yet
                    dialog5Minutes = new Dialog("You will be disconnected", new String[] {"OK"}, new int[]{1}, 1, null);
                    ui.pushGlobalScreen(dialog5Minutes, 1,UiEngine.GLOBAL_QUEUE);
                    if ( dialog4Minutes != null ) {
                        dialog4Minutes.close();
                        dialog4Minutes = null;
                    }
                }
            }
        }
    }
};