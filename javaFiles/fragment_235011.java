String url = "/demoapi/api/user/123";
    String newurl = "/user/?user=$1";

    Pattern pattern = Pattern.compile(".*/user/(\\d*)");
    Matcher match = pattern.matcher(url);
    if(match.matches()){
        newurl = newurl.replace("$1", match.group(1));
    }

    System.out.println(newurl);