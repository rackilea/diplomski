@Override
public void onActivityResumed(Activity activity) {
    mBackground = false;
}

@Override
public void onActivityPaused(Activity activity) {
    mBackground = true;
}