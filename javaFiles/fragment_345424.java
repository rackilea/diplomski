ActivityLifeCycleCallbackImpl activityLifeCycleCallback = new ActivityLifeCycleCallbackImpl();
    @Override
    public void onCreate() { 
        registerActivityLifecycleCallbacks(activityLifeCycleCallback);

}