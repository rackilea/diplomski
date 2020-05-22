ServletContext context = this.getServletContext();
String fullPath = context.getRealPath("/WEB-INF/yourOntologyName.owl");
ReadOntology.run(fullPath);
ExtendedIterator<OntClass> classIterator = ReadOntology.model.listClasses(); 
while (classIterator.hasNext()) { 
    OntClass ontClass = classIterator.next(); 
    System.out.println(ontClass.toString());
}