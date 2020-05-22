@Override
protected String[] doInBackground(String... params) {
    String songTitle = null;
    String streamTitle = null; // new
    Scraper scraper = new ShoutCastScraper();
    List<Stream> streams = null;
    try {
        streams = scraper.scrape(new URI(params[0]));
    } catch (URISyntaxException e) {
        e.printStackTrace();
    } catch (ScrapeException e) {
        e.printStackTrace();
    }
    for (Stream stream: streams) {
        songTitle = stream.getCurrentSong();
        streamTitle = stream.getTitle(); // new. I don't know what method you call to get the stream title - this is an example.
    }
    return new String[] {songTitle, streamTitle}; // new
}

@Override
protected void onPostExecute(String[] s) {
    super.onPostExecute(s); // this like is unnecessary, BTW
    MainActivity.songTitle.setText(s[0]);
    MainActivity.streamTitle.setText(s[1]); // new. Or whatever you want to do with the stream title.
}