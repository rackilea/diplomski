@Inject Bus mBus;

public GcmBroadcastReceiver() {
    Injector.getInstance().inject(this);

}