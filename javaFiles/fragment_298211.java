Collections.sort(
  myArticles_MapList, // your specific list to be sorted
  new Comparator<Articles_Map>() {
    public int compare(Articles_Map o1, Articles_Map o2) {
      // Improve this to handle null publishedAt (make it early Paleozoic?)
      return o1.getPublishedAt().compareTo(o2.getPublishedAt());
    }
  }
)