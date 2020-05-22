String regex = "http://(.*)\\.mysite\\.com/(.*)/images/(.*)\\.jpg";
    String   url = "http://www.mysite.com/work/images/cat.jpg";
    Pattern pattern = Pattern.compile (regex);
    Matcher matcher = pattern.matcher (url);

    if (matcher.matches ())
    {
        int n = matcher.groupCount ();
        for (int i = 0; i <= n; ++i)
            System.out.println (matcher.group (i));
    }