final Fragment existing = getSupportFragmentManager().findFragmentByTag(tag);

if (existing == null) {
    final Fragment newInstance = MyFragment.newInstance();
       getSupportFragmentManager()
           .beginTransaction()
           .add(R.id.fragmentContainer, newInstance, tag)
           .commit();
 }