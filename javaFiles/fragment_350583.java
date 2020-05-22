try {
    File globalPref = new File(System.getProperty("user.home") + "/Library/Preferences/.GlobalPreferences.plist");
    NSDictionary dict = (NSDictionary)PropertyListParser.parse(globalPref);

    NSNumber pref = (NSNumber)dict.objectForKey("com.apple.swipescrolldirection");

    if(pref.boolValue()) {
        //natural scrolling is enabled
    }  
} catch (Exception ex) {
    System.out.println("Faild to parse plist: " + ex.getMessage());
}