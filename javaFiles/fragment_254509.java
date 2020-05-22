Class clazz = String.class;
    String name = clazz.getName().replace('.', '/') + ".class";
    System.out.println(name);
    String loc = clazz.getClassLoader().getResource(name).toString();
    System.out.println(loc);
    if (loc.startsWith("jar:file")) {
        String propertyResource = loc.substring(0, loc.indexOf('!')) + "!" + "/META-INF/MANIFEST.MF";
        InputStream is = new URL(propertyResource).openStream();
        System.out.println(propertyResource);
        Properties props = new Properties();
        props.load(is);
        System.out.println(props.get("Implementation-Title"));
    }