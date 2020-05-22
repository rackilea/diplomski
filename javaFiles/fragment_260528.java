public class Book {

            @NotEmpty(message="please fill author")
            pirvate String author;
            @NotEmpty("message="please fill title")
            private String title;
            @NotNull(message="you get my drift ;)")
            private Map<K,V> someMap;

            public Book(String author,String title, Map map){
               this.author = author;
            //blah blah no need for the setters...
            }

// blah blah other getters and setters

 }