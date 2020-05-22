final StmtIterator it = model.listStatements();
while (it.hasNext())
{
    final Statement s = it.next();
    if (s.getPredicate().equals(RDFS.subClassOf) && !s.getObject().isAnon())
            System.out.println(s.getSubject() + " extends " + s.getObject());
}