public int getIdFromString(String postId) {
    String finalId;
    while (postId.indexOf("_") > 0) {
        finalId = postId.substring(0, postId.indexOf("_"));
        postId = finalId.concat(postId.substring(postId.indexOf("_") + 1));
    }
    return Integer.valueOf(postId);
}