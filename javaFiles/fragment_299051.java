tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
@Override
public void onTabSelected(TabLayout.Tab tab){
    int position = tab.getPosition();
    // Execute here based on position 
    switch(position){
        case 0 :

        break;
        case 2 : 
        addToCalendar();
        break;         
   }
});