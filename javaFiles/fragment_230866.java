Map<String, List<String>> mapOfPosts = new HashMap<>();

List<String> post1Comments = new ArrayList<>();

// Collect comments of a certain post
post1Comments.add("comment1");
post1Comments.add("comment2");
...

// Attach comments to post
mapOfPosts.put("post1", post1Comments);

// Repeat this for all posts