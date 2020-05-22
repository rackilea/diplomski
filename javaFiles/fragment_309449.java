@Override
public void run(String... args) throws Exception {

    Comments comments1 = new Comments();
    comments1.setName("comment1");
    comments1.setDesc("desc1");

    Comments comments2 = new Comments();
    comments2.setName("comment2");
    comments2.setDesc("desc2");

    Posts posts = new Posts();
    comments1.setPosts(posts);
    comments2.setPosts(posts);
    posts.setName("post5");
    posts.getComments().add(comments1);
    posts.getComments().add(comments2);

    postsRepository.save(posts);
}