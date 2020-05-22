private int tabSelected = 0;

@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
    if(tab.getPosition()==0)
    {
        tabSelected = 0;
        CalendarFragment frag = new CalendarFragment();
        ft.replace(android.R.id.content, frag);
    }
    else
    {
        tabSelected = 1;
        ConverterFragment frag = new ConverterFragment();
        ft.replace(android.R.id.content, frag);
    }
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    Intent newActivity;
    // Handle item selection
    switch (item.getItemId()) 
        case R.id.menu_today_date:
           FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
           if (tabSelected == 0){
                CalendarFragment frag = new CalendarFragment();
                ft.replace(android.R.id.content, frag);


           }
           else {
                ConverterFragment frag = new ConverterFragment();
                ft.replace(android.R.id.content, frag);
           }

           ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
           ft.commit();

        default:
            return super.onOptionsItemSelected(item);
    }
}