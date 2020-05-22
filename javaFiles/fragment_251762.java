private Menu mMenu;
@Override
public boolean onCreateOptionsMenu(Menu menu){
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.menu_main_activity, menu);
// Save the menu reference
mMenu = menu;
return super.onCreateOptionsMenu(menu);
}

// For example - Call when you need to change icon
 private void setActionIcon(boolean showWithBadge){
   MenuItem item = mMenu.findItem(R.id.ITEM_ID);
    if(mMenu != null){
        if(showWithBadge){
           item.setIcon(R.drawable.IC_WITH_BADGE);           
          }
           else {
            item.setIcon(R.drawable.IC_WITHOUT_BADGE);
         }
     }
 }