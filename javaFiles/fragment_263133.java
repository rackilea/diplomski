/* Add this method in your host Activity */
public void attachFragment(Fragment fragment) {

    if (null == fragment) {
        return;
    }

    try {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragContainer, fragment);
        /* add to back stack */
        //ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    } catch (Exception e) {
    }
}