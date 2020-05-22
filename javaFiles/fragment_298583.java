public List<String> getPages() {
    List<String> result = new ArrayList<String>();
    for (final String pageName : this.componentClassResolver.getPageNames()) {
        String className = this.componentClassResolver.resolvePageNameToClassName(pageName);
        Class clazz = loadClass(className);
        if (clazz.isAnnotationPresent(MainPage.class)) {
            result.add(pageName);
        }
    }
    return result;
}