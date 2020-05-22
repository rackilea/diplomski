public void addSampleData() {
    people.add(new User("pe3", UserType.ADMIN,"Peter"));
    people.add(new User("u987", UserType.EDITOR,"Udo"));
    people.add(new User("frank123", UserType.USER,"Frank"));
    // repeat ...
}

public User getUser(int idx) {
    return people.get(idx); 
}

public void printUsernames(){
    for (User user: people){
        System.out.printf("%s %s\n", user.getUsername(), user.getuserType);
    }
}