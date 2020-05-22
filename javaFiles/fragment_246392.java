@Override
public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);

    menu.setHeaderTitle("Context Menu");
    Button buttonView = (Button) v; 
    menu.add(0, buttonView .getId(), 0, buttonView.getText());
}