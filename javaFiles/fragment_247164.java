Intent myintent = getIntent();
    String[] activeURL = myintent.getStringArrayExtra("URL");
    List<String> titles = new ArrayList<String>();

    // fetching all active URLs
    //use a for each loop
    for ( String url : activeURL ) {
        //loop through messages parsed from feed to add titles
        for (Message msg : new BaseFeedParser(url).parse() ) {
           titles.add(msg.getTitle());
        }
    }