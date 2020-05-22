String locationPrefix = "classpath*:META-INF/spring/";
String locationSiffix = "/*.xml";

List<String> configLocations = new ArrayList<String>();
configLocations.add(locationPrefix + "core" + locationSiffix);

List<String> pluginsTurnedOn = getPluginsTurnedOnFromConfiguration();
for (String pluginName : pluginsTurnedOn) {
    configLocations.add(locationPrefix + pluginName + locationSiffix);
}

applicationContext.setConfigLocations(configLocations.toArray(new String[configLocations.size()]));