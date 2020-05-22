public void showPopup() {
    PopupMenu popup = new PopupMenu(context, <PASS ID WHERE YOU WISH TO SHOW POPUP>);
    popup.getMenuInflater().inflate(R.menu.menu_option, popup.getMenu());
    Object menuHelper;
    Class[] argTypes;
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.member:
                    // call member class or function here
                    return true;
                case R.id.guest:
                    // call Guest class or function here
                    return true;
                case R.id.my_buddies:
                    // call My Buddies class or function here
                    return true;
            }
            return true;
        }
    });
    popup.show();
}