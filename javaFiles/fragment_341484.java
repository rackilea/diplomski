//Create a new comment
    Comment comment = new Comment(author, text, rating);

    //Add comment to comments arraylist
    comments.add(comment)  which is same as

    //Other way to add to list 
    comments.add(new Comment(author, text, rating));