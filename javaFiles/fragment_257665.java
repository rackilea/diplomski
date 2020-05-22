@Inject
EModelService modelService;

@Inject
MApplication app;

List<MMenuItem> menuList = modelService.findElements(app, "menu item id", MMenuItem.class, null, EModelService.IN_MAIN_MENU);

MMenuItem menuItem = menuList.get(0);