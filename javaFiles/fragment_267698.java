class Group {
    private Map<String, User> users;

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}