if(saveInstanceState == null)
{
    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    HomePage_Fragment myfragment = new HomePage_Fragment();

    ft.add(R.id.scroll2, myfragment);

    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
    ft.commit();
}