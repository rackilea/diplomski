@Override
public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "onReceive " + intent.getAction());
    if (ACTION_PROFILE_PROVISIONING_COMPLETE.equals(intent.getAction())) {
        PersistableBundle extras = intent.getParcelableExtra(
                EXTRA_PROVISIONING_ADMIN_EXTRAS_BUNDLE);
        Log.d(TAG, "onReceive Extras:" + extras.getString("Key1") + " / "  + extras.getString("Key2"));
    }
}