String query = "https://www.something.comsignin/service?username=test&pwd=test&profile=developer&role=ELITE&key=manager";
    URL u = new URL(query);
    String param = u.getQuery();
    String paramSplit[] = param.split("&");
    System.out.println(paramSplit[0] + "\n" + paramSplit[1]); //only username and password
    for (String s : paramSplit)
        System.out.println(s);