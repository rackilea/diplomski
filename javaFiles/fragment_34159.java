//First level
            @Root (name = "feed")
            public class Feed { // All lines

                @Element("id")
                private String id;

                @Element("author")
                private Author_feed author;

                @Element("title")
                private String title;

                @Element("updated")
                private String updated;

                @ElementList(inline = true, entry = "entry")
                private List<WhatsNewFeed_entry> entries;
            }

           //Note that there is no root because it was already defined in the first level,
//this way you can use the same class in differents node with different tag names, you 
//could even make an abstract class of author and in one just post the uri class isntead of
// 2 author classes with the same properties
        public class Author_feed {  // Lines 03-07

            @Element("name")
            private String name;

            @Element("uri")
            private String uri;

            @Element("id")
            @Namespace(prefix = "y")
            private String id;
        }


        class Author_entry {  // Lines 12-15

            @Element("name")
            private String name;

            @Element("id")
            @Namespace(prefix = "y")
            private String id;
        }


        public class WhatsNewFeed_entry { // Lines 10-16

            @Element (name = "id")
            private String id_entry;

            @Element("author")
            private Author_entry author;
        }