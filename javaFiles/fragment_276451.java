if (index >= 0) { 
    bDeleteMenu.setEnabled(true);
} else { 
    bDeleteMenu.setEnabled(false);
}
Menu selectedMenu = (Menu)menuList.getSelectedValue();
menuName.setText(selectedMenu.getMenuName());