try {
        StringBuilder sb=  new StringBuilder();
        while ((rsslink = br.readLine()) != null) 
        {
               sb.append(rsslink);
        }
        rsslink = sb.toString();
    }