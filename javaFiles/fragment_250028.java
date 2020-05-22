Connection.Response res = null;
Document doc = null;

try {   //first connection with GET request
        res = Jsoup.connect("https://parents.mtsd.k12.nj.us/genesis/parents?gohome=true")
//                  .userAgent(YourUserAgent)
//                  .header("Accept", WhateverTheSiteSends)
//                  .timeout(Utilities.timeout)
                    .method(Method.GET)
                    .execute();         
    } catch (Exception ex) {
        //Do some exception handling here
    }
try {
        doc = Jsoup.connect("https://parents.mtsd.k12.nj.us/genesis/parents/j_security_check"")
    //          .userAgent(YourUserAgent)
    //          .referrer(Referer)
    //          .header("Content-Type", ...)
                .cookies(res.cookies())
                .data("j_username",username)
                .data("j_password",password)                    
                .post();
    } catch (Exception ex) {
        //Do some exception handling here
    }
    //Now you can use doc!