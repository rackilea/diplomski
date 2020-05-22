private void printFBMessages(FileWriter fileWriter, String nameFeed)
        throws InterruptedException, IOException, FacebookException {
    boolean notEmpty = true;

    facebook4j.ResponseList<Post> posts = facebook.getFeed(nameFeed, new Reading().limit(100));

    while (notEmpty) {
        try {
            notEmpty = false;

            for (Post post : posts) {
                notEmpty = true;
                MessageInfo msg = new MessageInfo();
                msg.setDate(post.getCreatedTime().toString());
                msg.setTitle(post.getMessage());
                System.out.println(msg);

                addControleToResult(fileWriter, nameFeed, msg);
            }               
            posts = facebook.fetchNext(posts.getPaging());
        } catch (FacebookException ex) {
            System.out.println(ex.getMessage());
            Thread.sleep(300000);
        }
    }
    System.out.println("Done!");
    return;
}