public void button1click (View view) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.container,new Fragment2());
    fragmentTransaction.commit();
    fragmentTransaction.addToBackStack(null);
}