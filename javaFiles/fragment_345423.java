class ActivityLifeCycleCallbackImpl implements  Application.ActivityLifecycleCallbacks {

    private Set<Activity> set = new HashSet<>();


    @Override
    public void onActivityStarted(Activity activity) {
        set.add(activity);
    }

    @Override
    public void onActivityStopped(Activity activity) {
        set.remove(activity);

    }

    Activity getCurrentActivity() {
        if (set.isEmpty()) {
            return null;
        }
        return set.iterator().next();
    }


}