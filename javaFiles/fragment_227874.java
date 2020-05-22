public String getQueryPart(URL url, String key) {
    String query = url.getQuery();
    if(query == null)
       return null;
    String[] parts = query.split("[&=]");
    for(int i = 0; i < parts.length; i+=2) {
       if(parts[i].equals(key)) {
          return parts[i+1];
       }
    }
}