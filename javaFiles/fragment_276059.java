MenuBar menuBar = new MenuBar();
menuList.stream().forEach(x -> {
    if (isParentMenu(x.getId())) {
        menuBar.addMenu(x);
    } else {
        Menu parent = getMenuById(x.getParentId());
        menuBar.addChildMenu(parent, x);
    }
});