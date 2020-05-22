class ExpandableURLPool implements URLPool {
List<String> urlList = new ArrayList<String>();
int cursor = 0;

int outstandingQueryies = 0;

public ExpandableURLPool(Collection<String> seedURLS) {
    urlList.addAll(seedURLS);
}

@Override
public boolean hasNextQuery() {
   return  cursor < urlList.size() || outstandingQueryies > 0;

}

@Override
public Query getNextQuery() throws URLPoolException {
    try {
        if (cursor >= urlList.size()) {
            return null;
        } else {
            outstandingQueryies++;
            return new Query( urlList.get(cursor++) ) ;
        }
    } catch (MalformedURLException e) {
        throw new URLPoolException( "invalid url", e ) ;
    }    
}

@Override
public void setProcessed(Query query) {
    outstandingQueryies--;


}

public void addURL(String url) {
    urlList.add(url);
}

}