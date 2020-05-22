//idea class
public class NewIdea extends DomainObject implements Membership {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "key.idea", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<NewIdeaParticipation> newIdeaParticipations = new HashSet<NewIdeaParticipation>();
}

//participation class
@Entity
@Table(name = "newidea_student")
@AssociationOverrides({
        @AssociationOverride(name = "key.student",
                joinColumns = @JoinColumn(name = "role_id")),
        @AssociationOverride(name = "key.idea",
                joinColumns = @JoinColumn(name = "idea_id")) })
public class NewIdeaParticipation implements Serializable {
    @EmbeddedId
    private NewIdeaParticipationId key = new NewIdeaParticipationId();
}

//id class
@Embeddable
public class NewIdeaParticipationId implements Serializable {
    @ManyToOne
    private Student student;
    @ManyToOne
    private NewIdea idea;
}

//student class
public class Student extends Role {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "key.student", cascade=CascadeType.ALL, orphanRemoval=true)
    private Set<NewIdeaParticipation> newIdeaParticipations = new HashSet<NewIdeaParticipation>();
}

//the filter
private BooleanExpression authorFilter(Student author) {
    return QNewIdea.newIdea.newIdeaParticipations.any().key.student.eq(author);
}