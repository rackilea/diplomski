public class GluonPlatformFactory {

    public static GluonPlatform getPlatform() {
        try {
            String platform = System.getProperty("javafx.platform", "desktop");
            String path = "org.gluonoss.vibrator.GluonDesktopPlatform";
            if(platform.equals("android")) {
                path = "org.gluonoss.vibrator.GluonAndroidPlatform";
            } else if(platform.equals("ios")) {
                path = "org.gluonoss.vibrator.GluonIosPlatform";
            }
            return (GluonPlatform) Class.forName(path).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Platform Error "+e.getMessage());
        }
        return null;
    }
}