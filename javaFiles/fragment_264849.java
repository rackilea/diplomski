@ManyToMany(fetch = FetchType.EAGER)
@JoinTable(name = "USERS_COURSES",
        joinColumns = {@JoinColumn(name = "COURSE_ID")},
        inverseJoinColumns = {@JoinColumn(name = "USER_ID")})
@WhereJoinTable(clause = "ROLE = 1")
@SQLInsert(sql = "insert into USERS_COURSES (COURSE_ID, USER_ID, ROLE) values (?, ?, 1)")
@SortComparator(User.FullNameComparator.class)
public SortedSet<User> getStudents() {
    return students;
}