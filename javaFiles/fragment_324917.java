@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {
    if (tab.getPosition() == 0) {
        CalendarFragment frag = new CalendarFragment();
        ft.replace(R.id.main, frag);
    } else {
        ConverterFragment frag = new ConverterFragment();
        ft.replace(R.id.main, frag);
    }
}