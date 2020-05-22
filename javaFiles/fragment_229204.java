public class SystemPropTestContextBootstrapper extends WebTestContextBootstrapper {

    @Override
    protected MergedContextConfiguration processMergedContextConfiguration(MergedContextConfiguration mergedConfig) {
        WebAppConfiguration webAppConfiguration = AnnotationUtils.findAnnotation(mergedConfig.getTestClass(),
                WebAppConfiguration.class);
        if (webAppConfiguration != null) {
            //implementation ommited
            String webappDir = loadWebappDirFromSystemProperty();
            if(webappDir == null) {
                webappDir = webAppConfiguration.value();
            }
            return new WebMergedContextConfiguration(mergedConfig, webappDir);
        }

        return mergedConfig;
    }
}