WebDriver driver;
if(platform.equals("Android")){
    driver = COMMON.startAndroid(name, id, platform, version);
} else {
    driver = COMMON.startIOS(name, id, platform, version);
}