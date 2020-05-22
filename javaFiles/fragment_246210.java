@Override
public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
        if(flag)
        {
        menu.add("hi");
        menu.add("this");
        }
        else
        {
            menu.add("context");
            menu.add("menu");
        }
    super.onCreateContextMenu(menu, v, menuInfo);
}