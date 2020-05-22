public static Map<String,String> optionsTitle() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Place c: Place.find.orderBy("title desc").findList()) {
            options.put(c.title, c.title);
        }
        return options;
    }   
    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<String,String>();
        for(Place c: Place.find.orderBy("title desc").findList()) {
            options.put(c.id.toString(), c.title);
        }
        return options;
    }