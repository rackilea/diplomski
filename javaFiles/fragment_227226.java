public class Test {
   private static Function s = new Function<Pageview, Tuple2<String, Long>>() {

     @Override
     public Tuple2<String, Long> call(Pageview pageview) throws Exception {
       String key = pageview.getUrl().toString();
       Long value = getDay(pageview.getTimestamp());
       return new Tuple2<>(key, value);
      }
  };
}