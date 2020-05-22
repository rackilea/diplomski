String s = "[TPIN{PrimaryPIN=6152987; IsValidUser=true; }, TPIN{PrimaryPIN=794032; IsValidUser=true; }]";
    Pattern pinPattern = Pattern.compile("PrimaryPIN=([0-9]*);");
    Pattern vuPattern = Pattern.compile("IsValidUser=([^;]*);");
    ArrayList<String> pins = new ArrayList<String>();
    ArrayList<Boolean> validUser = new ArrayList<Boolean>();
    Matcher m = pinPattern.matcher(s);
    while (m.find()) {
        pins.add(m.group(1));
    }
    m = vuPattern.matcher(s);
    while (m.find()) {
        validUser.add("true".equals(m.group(1))?true:false);
    }