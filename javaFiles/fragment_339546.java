FXMLLoader loader = new FXMLLoader();
loader.setController(TabController.this);

try {
    addURLToSystemClassLoader(new URL("hive://" + pageURL.getHost() + ":" + pageURL.getPort() + "/" + pageURL.getApplicationName() + "/origJar.jar"));
} catch (Exception e) {
    e.printStackTrace();
}