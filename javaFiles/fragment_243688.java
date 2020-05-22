class User implements Comparable<User>{
    private String name;
    private long id;
    private Date age;
    private boolean gender;
    @Override
    public int compareTo(User user1) {
        return this.age.compareTo(user1.age);
    }
} 

List<User> users = new ArrayList();
users.add(user);
...
Collections.sort(list);