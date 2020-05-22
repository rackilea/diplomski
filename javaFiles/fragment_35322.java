@Override
public void sendData(String a, String b) {
    MainFragment mainFragment = new MainFragment();
    Bundle bundle = new Bundle();
    bundle.putString("A", a);
    bundle.putString("B", b);
    mainFragment.setArguments(bundle);
    getSupportFragmentManager().beginTransaction().replace(R.id.container,mainFragment).commit();

}