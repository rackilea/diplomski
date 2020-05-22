public static void main(String[] args) {
          Filter f = FilterFactory.getFilter("aaa"); // call from user1
          Filter g = FilterFactory.getFilter("bbb"); // call from user2
          Filter h = FilterFactory.getFilter("aaa"); // call from user3
          System.out.println(f == h); // same filter
    }

    class FilterFactory {
       private static Map<String, Filter> map = new HashMap<>();

       private FilterFactory() {
       }

       public static Filter getFilter(String letters) {
          return map.computeIfAbsent(letters, Filter::new);
       }

 // Pre-java 8 version
       public static Filter getFilter2(String letters) {
          Filter f = map.get(letters);
          if (f == null) {
             f = new Filter(letters);
             map.put(letters, f);
          }
          return f;
       }

    class Filter {
       String f;

       public Filter(String f) {
          this.f = f;
       }

       public String toString() {
          return f;
       }
    }