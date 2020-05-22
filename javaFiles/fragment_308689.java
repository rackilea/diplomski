public static void addToUserList(User newUser){
    for (User user : users) {
        if(user.getUserID() == newUser.getUserID()){
            System.out.println("DUPLICATED USER ID: " + user.getUserID() + "ALREADY EXISTS");
            return;
        }
    }

    users.add(newUser);
}