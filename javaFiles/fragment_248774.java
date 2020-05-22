public Fragment fragment;
public void navigateTo(Fragment newFragment,boolean addToBackStack) {
    this.fragment = newFragment;
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction ft = manager.beginTransaction();
    ft.replace(R.id.fragment_container, newFragment);
    if(addToBackStack)
        ft.addToBackStack(fragment.getClass().getSimpleName());
    ft.commit();
}