@Embeddable
public class ConceptPk implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    public Concept conceptUriSubject;
    public Concept conceptUriObject;
    public Concept conceptUriPredicate;

    @Id 
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="uri_concept_subject")
    public Concept getConceptUriSubject() {
        return conceptUriSubject;
    }
    public void setConceptUriSubject(Concept conceptUriSubject) {
        this.conceptUriSubject = conceptUriSubject;
    }

    @Id 
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="uri_concept_object")
    public Concept getConceptUriObject() {
        return conceptUriObject;
    }
    public void setConceptUriObject(Concept conceptUriObject) {
        this.conceptUriObject = conceptUriObject;
    }

    @Id 
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="uri_concept_predicate")
    public Concept getConceptUriPredicate() {
        return conceptUriPredicate;
    }
    public void setConceptUriPredicate(Concept conceptUriPredicate) {
        this.conceptUriPredicate = conceptUriPredicate;
    }