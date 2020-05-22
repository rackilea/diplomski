Resource pageA; //LiveCopy of Page B;
LiveRelationshipManager liveRelationshipManager = resourceResolver.adaptTo(LiveRelationshipManager.class);
PageManager pageManager = resourceResolver.adaptTo(PageManager.class);

LiveRelationship liveRelationship = liveRelationshipManager.getLiveRelationship(pageA, false);
String pageBPath = liveRelationship.getSourcePath();

Page pageB = pageManager.getPage(pageBPath);