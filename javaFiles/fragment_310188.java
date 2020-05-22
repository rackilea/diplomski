for (final OWLSubClassOfAxiom subClasse : ontology.getAxioms(AxiomType.SUBCLASS_OF))
{
    if (subClasse.getSuperClass() instanceof OWLClass 
         && subClasse.getSubClass() instanceof OWLClass)
    {
        System.out.println(subClasse.getSubClass() 
             + " extends " + subClasse.getSuperClass());
    }
}