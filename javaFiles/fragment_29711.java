public void printArray(List<User> users){
    if (users.isEmpty()){
        System.out.println("No users found.");
    }
    for (User currentUser : users) {
        System.out.println("First name = " + currentUser.getFirstName());
    }
}