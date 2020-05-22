List<App> list = ...;
for(Iterator<App> it = list.iterator(); it.hasNext(); ) {
    App app = it.next();
    String appName = app.getName();
    if (appName.equals(name)) {
        it.remove();
        System.out.println(appName + "has been removed.");
    }
}