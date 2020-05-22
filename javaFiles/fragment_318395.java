import java.io.File;
import java.util.Set;
import org.semanticweb.owl.explanation.api.Explanation;
import org.semanticweb.owl.explanation.api.ExplanationGenerator;
import org.semanticweb.owl.explanation.impl.blackbox.checker.InconsistentOntologyExplanationGeneratorFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import uk.ac.manchester.cs.jfact.JFactFactory;
public class TestExplanation {
  public static void main(String[] args) throws Exception {
    OWLReasonerFactory rf = new JFactFactory();
    OWLOntology ont = OWLManager.createOWLOntologyManager().createOntology();
    OWLOntologyManager m = ont.getOWLOntologyManager();
    OWLDataFactory df = m.getOWLDataFactory();
    OWLClass class1 = df.getOWLClass(IRI.create("urn:test:class1"));
    OWLClass class2 = df.getOWLClass(IRI.create("urn:test:class2"));
    OWLIndividual i = df.getOWLNamedIndividual(IRI.create("urn:test:i"));
    // create an inconsistent ontology by declaring an individual member of two disjoint classes
    m.addAxiom(ont, df.getOWLDisjointClassesAxiom(class1, class2));
    m.addAxiom(ont, df.getOWLClassAssertionAxiom(class1, i));
    m.addAxiom(ont, df.getOWLClassAssertionAxiom(class2, i));
    // create the explanation generator
    ExplanationGenerator<OWLAxiom> explainInconsistency = new InconsistentOntologyExplanationGeneratorFactory(rf,
        1000L).createExplanationGenerator(ont);
    // Ask for an explanation of `Thing subclass of Nothing` - this axiom is entailed in any inconsistent ontology
    Set<Explanation<OWLAxiom>> explanations = explainInconsistency.getExplanations(df.getOWLSubClassOfAxiom(df
        .getOWLThing(), df.getOWLNothing()));
    System.out.println("TestExplanation.main() " + explanations);
  }
}