ArrayList<RssItem> rssItems = feed.getRssItems();

Random rand = new Random(System.currentTimeMillis());

//Pick one at random
Log.i("RSS Reader", rssItems.get(rand.nextInt(rssItems.size())).getTitle();