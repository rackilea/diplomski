@OneToMany
@JoinTable
@Cascade(CascadeType.SAVE_UPDATE)
public List<User> getUsers() {
    return this.users;
}