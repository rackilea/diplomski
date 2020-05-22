public class ServiceCtrl<E extends Object> {
    private Class<E> mClass;

    ServiceCtrl(Context ctx, Class<E> sppServiceClass) {
        this.mCtx = ctx;
        this.mClass = sppServiceClass;
    }

    public boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) this.mCtx.getSystemService(this.mCtx.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (this.mClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}