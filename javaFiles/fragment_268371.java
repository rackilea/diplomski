public void add_user(String[] user) {
    if (user_count == max_users) {
        System.out.println("Sorry, the group is full!");
    }
    else {
        directory[user_count] = Arrays.toString(user); // HERE:  directory is null
        System.out.println("User added to group!");
        user_count++;   
    }
}