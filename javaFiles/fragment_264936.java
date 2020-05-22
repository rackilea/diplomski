@Entity(name = "Person")
public static class Person {

    @Id
    @Column(name = "id")
    private String id;


    @OneToMany(mappedBy = "person")
    private List<GroupAssociationEntity> groups;
}

@Entity(name = "GroupAssociationEntity")
public static class GroupAssociationEntity {

    @EmbeddedId
    private GroupAssociationKey id;

    @ManyToOne
    @MapsId("id")
    private Group group;

    @ManyToOne
    @MapsId("memberOf")
    private Person person;
}

@Embeddable
public static class GroupAssociationKey implements Serializable{

    private String id;

    private String memberOf;

    public GroupAssociationKey() {
    }

    public GroupAssociationKey(String id, String memberOf) {
        this.id = id;
        this.memberOf = memberOf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupAssociationKey)) return false;
        GroupAssociationKey that = (GroupAssociationKey) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getMemberOf(), that.getMemberOf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMemberOf());
    }
}

@Entity(name = "Group")
@Table(name = "groups")
public static class Group {

    @Id
    @Column(name = "id")
    private String id;

    @OneToMany(mappedBy = "group")
    private List<GroupAssociationEntity> persons;

}