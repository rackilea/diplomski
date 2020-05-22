public void addReview(String addRev) {
    // Reply is an ArrayList<Comment> of Comments not of Strings
    // this.Reply.add(addRev); // not working
    // you can create a new Comment and then add that comment
    this.Reply.add(new Comment("userId", addRev));
}

public void addReply(String addRep) {
    // same here
    // Reply.add(addRep); // not working and I cannot figure it out
    // you can create a new Comment and then add that comment
    this.Reply.add(new Comment("userId", addRep));
}