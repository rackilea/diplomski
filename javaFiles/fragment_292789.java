public static List getAuthModuleList(..)
{
    LinkedHashSet MODULE_SET = new LinkedHashSet();

    MODULE_SET.add(getAllrequiredModules());
    List userLevelModules = getAllUserLevelModules();

    if (userLevelModules != null) {
       MODULE_SET.addAll(userLevelModules);
    }
    userLevelModules = new ArrayList(MODULE_SET); //Exception here
    return userLevelModules;
 }