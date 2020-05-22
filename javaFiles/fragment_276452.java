if (index >= 0) { 
    bDeleteMenu.setEnabled(true);
    Menu selectedMenu = (Menu)menuList.getSelectedValue();
    menuName.setText(selectedMenu.getMenuName());
} else {
    bDeleteMenu.setEnabled(false);
}