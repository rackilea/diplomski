Map<Boolean, List<Menu>> map = menuList.stream().collect(Collectors.partitioningBy(x -> isParentMenu(x.getId())));
map.get(true).stream().forEach(menuBar::addMenu);
map.get(false).stream().forEach(x -> {
    Menu parent = getMenuById(x.getParentId());
    menuBar.addChildMenu(parent, x);
});