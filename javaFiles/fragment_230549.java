public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

       //It is very important that you save the current tab!
       private BaseFragment currentTab;

     // ...  implementation 



public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

         currentTab = null;

        switch (index) {
        case 0:
            // Top Rated fragment activity
            currentTab = new TopStoriesFragment();
       break;
        case 1:
            // Games fragment activity
            return new NationalFragment();
        case 2:
            // Movies fragment activity
            currentTab = new InternationalFragment();
          break;
        case 3:
            // Movies fragment activity
            currentTab = new SportsFragment();
           break;
        case 4:
            // Movies fragment activity
            currentTab = new TechnologyFragment();
        case 5:
            // Movies fragment activity
            currentTab = new BusinessFragment();
         break;
        case 6:
            // Movies fragment activity
            currentTab = new EntertainmentFragment();
        break;
        }


        return currentTab;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 7;
    }

    public void stop() {
        // get item count - equal to number of tabs
        return;
    }

}


@Override
public void onBackPressed() 
{
  //If the event returned false, then call the super.
  if(currentTab == null || !currentTab.onBackPressed())
  super.onBackPressed();
}

}