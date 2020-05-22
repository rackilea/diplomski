private void showPopup() {
    final PopupMenu popup = new PopupMenu(MainActivity.this, view);
    popup.getMenuInflater().inflate(R.menu.popup_shift, popup.getMenu());
    if(someCondition){
        popup.getMenu().findItem(R.id.menu_merge).setVisible(false);
    }
    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        public boolean onMenuItemClick(MenuItem item) {
            Toast.makeText(MainActivity.this, "You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        }
    });
    popup.show();
}