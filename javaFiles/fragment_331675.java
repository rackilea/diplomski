VideoEntry newEntry = new VideoEntry();

YouTubeMediaGroup mg = newEntry.getOrCreateMediaGroup();
mg.setTitle(new MediaTitle());
mg.getTitle().setPlainTextContent("My Test Movie");
mg.addCategory(new MediaCategory(YouTubeNamespace.CATEGORY_SCHEME, "Autos"));
mg.setKeywords(new MediaKeywords());
mg.getKeywords().addKeyword("cars");
mg.getKeywords().addKeyword("funny");
mg.setDescription(new MediaDescription());
mg.getDescription().setPlainTextContent("My description");
mg.setPrivate(false);
mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, "mydevtag"));
mg.addCategory(new MediaCategory(YouTubeNamespace.DEVELOPER_TAG_SCHEME, "anotherdevtag"));

newEntry.setGeoCoordinates(new GeoRssWhere(37.0,-122.0));
// alternatively, one could specify just a descriptive string
// newEntry.setLocation("Mountain View, CA");

MediaFileSource ms = new MediaFileSource(new File("file.mov"), "video/quicktime");
newEntry.setMediaSource(ms);

String uploadUrl =
  "http://uploads.gdata.youtube.com/feeds/api/users/default/uploads";

VideoEntry createdEntry = service.insert(new URL(uploadUrl), newEntry);