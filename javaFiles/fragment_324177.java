public String getUserId(ArrayList<User> newUsers, ArrayList<User> oldUsers, String email) {

    String userId = null;

    for (User user1 : newUsers) {
        if (user1.email.equals(email)) {
            userId = user1.uid;
            break;
        } 
    }

    if(userId == null){
        for (User user2 : oldUsers) {
            if (user2.email.equals(email)) {
                userId = user2.uid;
                break;
            }
        }
    }

    return userId;
}