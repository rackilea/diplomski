public static Iterable<String> iterable(final JSONArray array) {
   return new Iterable<String> {
       Iterator<String> iterator() {
          return new Iterator<String> {
             int i = 0;

             boolean hasNext(){
                return i < array.length();
             }

             String next(){
                return array.getString(i++);
             }

             void remove(){
                throw new RuntimeException(); //implement if you need it
             }
          }
       }
   };
}