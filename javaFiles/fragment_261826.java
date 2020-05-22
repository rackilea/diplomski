for(int i=0; i < tweetLength; i++)
    {
        if (i + 1 == tweetLength)
        {
            // avoid going out of bounds
            // when i == last char of the string
            break;
        }

        if (tweet.charAt(i) == '@')
            countMentions++;

        if (tweet.charAt(i) == '#')
            countHashtags++;

        if (i + 2 < tweetLength)
        {
            // search for i+2 only when
            // i+2 is not outside of the string
            if (((tweet.charAt(i) == 'R') || (tweet.charAt(i) == 'r')) && 
                    ((tweet.charAt(i + 1) == 'T') || (tweet.charAt(i + 1) == 't')) && 
                    (tweet.charAt(i + 2) == ':'))
            {
                retweet = true;
            }
        }
    }