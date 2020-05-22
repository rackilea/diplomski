SearchListResponse response = // data fetched from yt data api.
java.util.List<SearchResult> searchResultList = response.getItems();
for (SearchResult sr : searchResultList) {
   String thumburl = sr.getSnippet().getThumbnails().getDefault().getUrl();
//for high resolution you can use:  sr.getSnippet().getThumbnails().getHigh().getUrl();
}