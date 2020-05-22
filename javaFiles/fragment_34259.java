public class RSSFeeder<T extends DefaultHandler> extends AsyncTask<Void, Void, Void>{
   private T handler;

   public RSSFeeder(T handler, String feedURL) {
      this.handler = handler;
      this.feedURL = feedURL;
   }
   ...

}