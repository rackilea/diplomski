public int addMenuItem(int areaId, String name){
    MenuPoint[] newMenuItem = new MenuPoint[menuItem.length + 1];
    System.arraycopy(menuItem, 0, newMenuITem, 0, menuItem.length);
    menuItem = newMenuItem;
    menuItem[menuItem.length-1] = new MenuPoint();
    menuItem[menuItem.length-1].areaId = areaId;
    menuItem[menuItem.length-1].name = name;
    return menuItem.length; // Why -1 ? 
}