int count=0;
Connection<Post> pageFeed = facebookClient.fetchConnection(page.getId() + "/feed", Post.class);
for (List<Post> pageFeedConnectionPage : pageFeed)
    for (Post post : pageFeedConnectionPage) {
        count++;
        System.out.println("count------------------------>" + count);
        System.out.println("story-->" + post.getStory());
        System.out.println("message--->" + post.getMessage());
        System.out.println("postid---------->" + post.getId());
        System.out.println("----------------------------");
    }