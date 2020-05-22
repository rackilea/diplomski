while(rs.next()) {
    map.compute(rs.getString("menu"), (menu, subMenus) -> {
        Map<String, String> mapSubMenu = new LinkedHashMap<>();
        mapSubMenu.put("Submenu", rs.getString("sub-menu"));
        mapSubMenu.put("link", rs.getString("link"));

        subMenus = subMenus != null ? subMenus : new ArrayList<>();
        subMenus.add(mapSubMenu);

        return subMenus;
    });
}