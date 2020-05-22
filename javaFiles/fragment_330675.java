FragmentManager fm = getFragmentManager();
mTaskFragment = (TaskFragment) fm.findFragmentByTag(TAG_TASK_FRAGMENT);

// If the Fragment is non-null, then it is currently being
// retained across a configuration change.
if (mTaskFragment == null) {
   mTaskFragment = new TaskFragment();
   fm.beginTransaction().add(mTaskFragment, TAG_TASK_FRAGMENT).commit();
}