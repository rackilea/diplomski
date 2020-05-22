@Override
public void onTabSelected(Tab tab, FragmentTransaction ft) {

   Fragment mFragment;
   switch(tab.getPosition(){ 
     case 0:
       /* create fragment in here based on which tab, mFragment = new ExampleFrag */ 
       break;
     case 1:
       /* create fragment in here based on which tab, mFragment = new ExampleFrag */ 
       break;
   }

   ft.replace(android.R.id.content, mFragment);
}

@Override
public void onTabUnselected(Tab tab, FragmentTransaction ft) {
   // Dont need to do anything.
}