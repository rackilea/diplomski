@Override 
public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
{
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) menuInfo;
    _listPosition = info.position;      // Get Index of long-clicked item

    super.onCreateContextMenu(menu, v, menuInfo);
    menu.setHeaderTitle("Choose Action");   // Context-menu title
    menu.add(0, v.getId(), 0, "Edit");  // Add element "Edit"
    menu.add(0, v.getId(), 1, "Delete");        // Add element "Delete"
}