public <T extends PageBase> T navigateTo(Class<T> type) {
    driver.get(baseUrl + pagesToRelativePaths.get(type));

    return getPage(type);
}

public <T extends PageBase> T expectedLandingPage(Class<T> type) {
    return getPage(type);
}

private <T extends PageBase> T getPage(Class<T> type) {
    T page = null;

    try {
        page = type.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    } catch (InstantiationException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }

    return page;
}