popup.show();

//Set on click listener for the menu
popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
   @Override
   public boolean onMenuItemClick(MenuItem item) {
        if(id == R.id.menuNightMode) {
              openDialog();
        }
        return false;
   }
});