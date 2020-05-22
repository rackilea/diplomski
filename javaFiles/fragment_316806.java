String re = "(?sm)^Started\\s+(?<requesttype>\\S+)\\s+\"(?<url>\\S+)\"\\s+for\\s+(?<ip>\\d+(?:\\.\\d+)+)\\s+at\\s+(?<tsp>[a-zA-Z]+\\s+[a-zA-Z]+\\s+\\d+\\s+\\d+:\\d+:\\d+\\s+\\+\\d+\\s\\d{4})\\s+(?:Processing\\s+by\\s+\\S+)\\s+as\\s+(?<requestformat>\\S+)(?:\\s+Parameters:\\s+\\S+)?(?:(?:(?:(?!\nStarted ).)*Completed\\s)(?<responsecode>\\d+(?:(?!\\sin\\s).)*))?";
String str = "Started GET \"/google.com/2\" for 127.0.0.1 at Tue Dec 01 12:01:13 +0530 2015\n  Processing by MyController#method as JS\n  Parameters: {\"abc\" => \"xyz\"}\n[LOG] 3 : User text log\nCompleted 200 OK in 26ms (Views: 3.3ms | ActiveRecord: 2.9ms)\n\n\nStarted POST \"/google.com/543\" for 127.0.1.1 at Tue Dec 01 13:13:16 +0530 2015\n  Processing by MyController#method_2 as JSON\n  Parameters: {\"efg\" => \"uvw\"}\nCompleted 404 Not Authorized in 65ms (Views: 1.5ms | ActiveRecord: 1.0ms)";
Pattern pattern = Pattern.compile(re);
Matcher matcher = pattern.matcher(str);
List<String> requesttypes = new ArrayList<String>();
List<String> urls = new ArrayList<String>();
List<String> ips = new ArrayList<String>();
List<String> timestamps = new ArrayList<String>(); 
List<String> requestformats = new ArrayList<String>(); 
List<String> responsecodes = new ArrayList<String>();
while (matcher.find()){
    requesttypes.add(matcher.group("requesttype"));
    urls.add(matcher.group("url"));
    ips.add(matcher.group("ip"));
    timestamps.add(matcher.group("tsp"));
    requestformats.add(matcher.group("requestformat"));
    responsecodes.add(matcher.group("responsecode"));
    System.out.println("-----------------------");
    System.out.println(matcher.group("requesttype"));
    System.out.println(matcher.group("url")); 
    System.out.println(matcher.group("ip")); 
    System.out.println(matcher.group("tsp")); 
    System.out.println(matcher.group("requestformat")); 
    System.out.println(matcher.group("responsecode")); 
}