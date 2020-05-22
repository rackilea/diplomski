Connection.Response cr = Jsoup.connect(THE_URL)
                         .userAgent("Mozilla/5.0 (compatible; MSIE 10.6; Windows NT 6.1;                   Trident/5.0; InfoPath.2; SLCC1; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729; .NET CLR  2.0.50727) 3gpp-gba UNTRUSTED/1.0")
                         .cookie("auth", "token")
                         .timeout(5000)
                         .execute();

Document d = Jsoup.parse(cr.body(), "ISO-8859-1");