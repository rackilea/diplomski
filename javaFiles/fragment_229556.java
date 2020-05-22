private boolean identifiedLinksHasKey(String linkKey){
       synchronized(Parser) {
            return Parser.identifiedLinks.containsKey(linkKey);
        }
}

private void putToIdentifiedLinks(String key, TreeSet<String> aset){     
    synchronized(Parser) {    
        Parser.identifiedLinks.put(key,aset);
    }
}