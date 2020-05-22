String str = "CN=COUD111235,OU=Workstations,OU=Mis,OU=Accounts,DC=FL,DC=NET";
    String regex = "CN=([^,]*),";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(str);
    m.find();
    String computerName = m.group(1);