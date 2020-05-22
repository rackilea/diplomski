@NodeEntity
class Concept {
   private URI uri;
}
@NodeEntity
class Triple {
   // will be automatically mapped to a relationship with the name "subject"
   private Concept subject;
   // or provide explicit mapping
   @RelatedTo(elementClass=Concept.class, type = "PREDICATE")
   private Concept predicate;
   private Concept object;

   @RelatedTo(elementClass=Annotation.class, type = "HAS_ANNOTATION")
   private Set<Annotation> annotations;
}