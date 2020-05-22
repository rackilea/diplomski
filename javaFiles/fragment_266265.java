String str1 = "10.0.0.2 - frank [10/Oct/2000:13:55:36" + " -0700] \"GET /apache_pb.gif HTTP/1.0\" 200 2326 "
                  + "\"104.244.253.29\" \"Mozilla/4.08 " + "[en] (Win98; I ;104.30.244.2)\"";
    Pattern p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
    Matcher m = p.matcher(str1);
    while (m.find()){
        System.out.println(m.group(0));
    }