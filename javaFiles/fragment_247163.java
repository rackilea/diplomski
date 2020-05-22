Intent myintent = getIntent();
    //variables are named in camel case, starting with a lower case letter
    String[] activeURL = myintent.getStringArrayExtra("URL");

    List<String> titles = new ArrayList<String>();
    //we will use parser later, see below
    //BaseFeedParser parser = new BaseFeedParser(url);

    // fetching all active URLs
    //it's very easy to loop through a table in java / C / C++
    //learn the pattern, it's the simplest, you got confused with the final index
    for (int i = 0; i < activeURL.length ; i++) {
        //here you don't change the former object url was referencing,
        //you are saying that you give the name url to another object in the array
        //it doesn't create any new item, change giving them a name to use them
        url = activeURL[i];
        //create a new parser for each url, except if they can be recycled
        //i.e they have a property setUrl
        messages.addAll( new BaseFeedParser(url).parse());
    }

    // now getting the titles out of the messages for display
    for (Message msg : messages) {
        titles.add(msg.getTitle());
    }