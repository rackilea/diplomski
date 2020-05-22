public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
    if (v == Button1) {
        menu.setHeaderTitle("Select Notification");
        menu.add(0, v.getId(), 0, "Algebraic");
        menu.add(0, v.getId(), 0, "Knuckle Train");
        menu.add(0, v.getId(), 0, "In My Element ");
        menu.add(0, v.getId(), 0, "Let's Get This Party");
        menu.add(0, v.getId(), 0, "Shmowzow");
        menu.add(0, v.getId(), 0, "What the Jug");
        menu.add(0, v.getId(), 0, "Word to Your Mother");
    } else if (v == Button2) {
        // stuff for Button2
    }
}