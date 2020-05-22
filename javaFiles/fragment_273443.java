@Override
public void onNavigationDrawerItemSelected(int position) {
    // update the main content by replacing fragments
    switch(position)
    {
         case 0:
                    // FragmentCalendar
                    // use fragment transaction and add the fragment to the container
                    FragmentManager fragmentManager = getFragmentManager();
                    android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   
                    FragmentCalendar fragment = new FragmentCalendar();
                    fragmentTransaction.replace(R.id.container, fragment);
                    fragmentTransaction.commit();

         break;
         case 1:
                    // FragmentAddEvent
                     FragmentManager frag = getFragmentManager();
                     android.app.FragmentTransaction trans = frag.beginTransaction();   
                     FragmentAddEvent fragment2 = new FragmentAddEvent();
                     trans.replace(R.id.container, fragment2);
                     trans.commit();
         break; 
    } 
}