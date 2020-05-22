public static String subMenu(List<Menu> menus, String parentMenuId, boolean isSubMenu){
StringBuilder sb = new StringBuilder();

for(Menu menu : menus){         
    if(menu.getParentMenu()!=null && menu.getParentMenu().equalsIgnoreCase(parentMenuId)
            && menu.getActive() == Menu.MENU_ACTIVE){
        String menuId = menu.getMenuId();
        boolean isHasChild = false;

        for(Menu menuChild : menus){
            if(menuChild.getParentMenu()!=null && 
                    menuChild.getParentMenu().equalsIgnoreCase(menuId)){
                isHasChild = true;
            }
        }

        if(isHasChild){
            sb.append("<li>")
            .append("<a href=\"#\">")
            .append(menu.getDisplayName())
            .append("</a>");
        }else{                  
            sb
            .append("<li>")
            .append("<a href=\""+ contextPath + menu.getActualUrl()+"\">")
            .append(menu.getDisplayName())
            .append("</a>")
            .append("</li>");
        }

    }
}

sb.insert(0, "<ul>");
sb.append("</ul>");
return sb.toString();