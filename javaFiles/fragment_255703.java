Properties props = new Properties();
props.load(Main.class.getResourceAsStream("mydefault.properties"));

System.out.println("default loaded: " + props);

String configFile = System.getProperty("config");
if (configFile != null) {
    props.load(new FileInputStream(configFile));
    System.out.println("custom config loaded from " + configFile);
}

System.out.println("custom override: " + props);