private static void prettyPrint(Iterator<SearchResult> iteratorSearchResults, String query) {

System.out.println("\n=============================================================");
System.out.println(
    "   First " + NUMBER_OF_VIDEOS_RETURNED + " videos for search on \"" + query + "\".");
System.out.println("=============================================================\n");

if (!iteratorSearchResults.hasNext()) {
  System.out.println(" There aren't any results for your query.");
}

while (iteratorSearchResults.hasNext()) {

  SearchResult singleVideo = iteratorSearchResults.next();
  ResourceId rId = singleVideo.getId();

  // Double checks the kind is video.
  if (rId.getKind().equals("youtube#video")) {
    Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().get("default");

    System.out.println(" Video Id" + rId.getVideoId());
    System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
    System.out.println(" Thumbnail: " + thumbnail.getUrl());
    System.out.println("\n-------------------------------------------------------------\n");
  }
}
}