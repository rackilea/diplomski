public void onStartFragment(String className, int containerViewId) {

    FragmentManager manager = getChildFragmentManager();
    Fragment fragment = manager.findFragmentByTag(className);
    if (fragment == null) {
        fragment = Fragment.instantiate(context, className);
        // fragment is a className instance now
    }

    manager.beginTransaction()
               .replace(containerViewId, fragment, className)
               .addToBackStack(className)
               .commit();
}