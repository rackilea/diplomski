private void hideOption() {
    if (menu == null) return;
    MenuItem item = menu.findItem(R.id.action_info);
    item.setVisible(false);
}

private void showOption() {
    if (menu == null) return;
    MenuItem item = menu.findItem(R.id.action_info);
    item.setVisible(true);
}