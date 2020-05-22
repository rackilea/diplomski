Entity post = new Entity("Post");
List<String> tags = new ArrayList<String>();
tags.add("foo");
tags.add("bar");
post.setProperty("tags", tags);
datastore.put(post);