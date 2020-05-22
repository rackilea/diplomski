@Override
 public boolean onCreateOptionsMenu(Menu menu) {
     //inflate menu
     getMenuInflater().inflate(R.menu.top_navigation_menu, menu);

    MenuItem action_camera_menu_item = menu.findItem(R.id.action_camera);
    MenuItem action_gallery = menu.findItem(R.id.action_gallery);

    action_camera_menu_item.setVisible(conditionOK);
    action_gallery.setVisible(conditionOK);

    return true;
 }