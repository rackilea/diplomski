Map<String, List<Post>> map = new HashMap<String, List<Post>>();
// the categories variable here is the unique types from the Post table
for (String category : categories) {
    List<Post> posts = Post.find("type = ?", category).fetch();
    map.put(category, posts);
}
render(map);