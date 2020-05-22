Fragment fragment = null;

switch (position) {
    case 0:
        fragment = new AnotherFragment();
        break;
    case 1:
        fragment = new AnotherFragment();
        break;
    case 2:
        fragment = new AnotherFragment();
        break;
    case 3:
        fragment = new AnotherFragment();
        break;
    case 4:
        fragment = new AnotherFragment();
        break;
    case 5:
        fragment = new AnotherFragment();
        break;
    case 6:
        fragment = new AnotherFragment;
        break;
    case 7:
        fragment = new AnotherFragment();
        break;
    case 8:
        fragment = new AnotherFragment();
        break;
    case 9:
        fragment=null;
        break;
    default:
        break;
}

if (fragment != null)

{
    FragmentManager fragmentManager = getFragmentManager();
    fragmentManager.beginTransaction()
            .replace(R.id.container, fragment).commit();

} 
  else {

Intent logOut = new Intent(GroupHomeActivity.this, ElgarLoginActivity.class);
    getSharedPreferences("Pref", Context.MODE_PRIVATE).edit().clear().commit();
    logOut.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

   }