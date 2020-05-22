public final class Person {

    private final List<Role> mRoleList;

    public Person(final String fName, final String lName) {
        ...
        mRoleList = new LinkedList<>();
    }

    public void addRole(final Role role) {
        mRoleList.add(role);
    }

    public boolean hasRole(final Role role) {
        return mRoleList.contains(role);
    }

    public List<Role> getRoles() {
        return Collections.unmodifiableList(mRoleList);
    }

}