//Keywords
mg.setKeywords(new MediaKeywords());
int totalTagsLimit = 500; // characters
int singleTagLimit = 30; // characters
int totalTags = 0; //characters
for (String tag : tags) {
  if ((totalTags + tag.length()) < totalTagsLimit && tag.length() < singleTagLimit) {
    mg.getKeywords().addKeyword(tag);
    totalTags += tag.length();
  }
}