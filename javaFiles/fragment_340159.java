String tweetMessage = "";
    String shortUrl = shortUrl(String somedata);
    if (!Util.isNullOrEmpty(shareText)){
        int len = shareText.length();
        int mlen = 140-(shortUrl.length()+8);
        int tlen = Math.min(len, mlen);
        String separator = " ... ";
        if(tlen!=mlen)
        {
            separator = " - ";
        }
        tweetMessage = shareText.substring(0, tlen)+separator+shortUrl;
    }
    else
    {
        tweetMessage = "Checkout ... "+shortUrl;
    }


        try {


        //send a tweet here... 

        } catch (Exception e) {
            e.printStackTrace();
        }