@Entity
@IdClass(ConceptPk.class)
@Table(name = "triple")
public class TripleDBModel {

    protected List<Annotation> annotations;
    public Concept conceptUriSubject;
    public Concept conceptUriObject;
    public Concept conceptUriPredicate;



    @ManyToMany(
            cascade={CascadeType.ALL }, 
            fetch=FetchType.LAZY
    )   
    @JoinTable(name = "triple_has_annotation", 
            joinColumns={@JoinColumn(name="uri_concept_subject"), @JoinColumn(name="uri_concept_object"), @JoinColumn(name="uri_concept_predicate") },          
            inverseJoinColumns=@JoinColumn(name="annotation_id") )
    public List<Annotation> getAnnotations() {
        return annotations;
    }
    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }
    @Id 
    @Column(name = "uri_concept_subject", length = 100)
    public Concept getConceptUriSubject() {
        return conceptUriSubject;
    }
    public void setConceptUriSubject(Concept conceptUriSubject) {
        this.conceptUriSubject = conceptUriSubject;
    }
    @Id 
    @Column(name = "uri_concept_object", length = 100)
    public Concept getConceptUriObject() {
        return conceptUriObject;
    }
    public void setConceptUriObject(Concept conceptUriObject) {
        this.conceptUriObject = conceptUriObject;
    }
    @Id 
    @Column(name = "uri_concept_predicate", length = 100)
    public Concept getConceptUriPredicate() {
        return conceptUriPredicate;
    }
    public void setConceptUriPredicate(Concept conceptUriPredicate) {
        this.conceptUriPredicate = conceptUriPredicate;
    }

}