class CVSParser {
     public static <T> Set<T> parse(RecordHandler<T> handler, File f) {
        //...        
     }
}


Set<Item> items = CVSParser.parse(new ItemHandler(), itemsFile);