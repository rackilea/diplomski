@Entity
class Dashboard {

    @OneToMany(mappedBy = "dashboard", cascade = CascadeType.ALL)
    private List<Group> groups;

}

@Entity
class Group{

    @ManyToOne(fetch = FetchType.LAZY)
    private Dashboard dashboard;

}