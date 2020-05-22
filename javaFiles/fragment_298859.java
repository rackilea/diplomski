LinkedHashMap<String, ArrayList<String>> menuSubMenu = new LinkedHashMap<String, ArrayList<String>>();

        while(true){
            String key = rs.getString("menu_name");
            if(!menuSubMenu.containsKey(key)){
                menuSubMenu.put(key, new ArrayList<String>());
            }
            menuSubMenu.get(key).add(rs.getString("sub_menu_name"));
        }