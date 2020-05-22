@Override
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);

    AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
    MyObject obj = (MyObject) myListView.getItemAtPosition(info.position);

    menu.setHeaderTitle("Selection Options");  
    menu.add(0, v.getId(), 0, "Remove " + obj.name); 
}