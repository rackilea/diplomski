@Entity
class Dashboard {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Group> groups;

}

@Entity
class Group{


}