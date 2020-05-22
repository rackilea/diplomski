public void setMenuFragment(Fragment fragment) {
    FragmentManager manager = this.activity.getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.replace(R.id.flMenuContainer, fragment);
    transaction.commit();
}