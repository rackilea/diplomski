main(){
StaxEventItemReader<Student> xmlFileReader = new StaxEventItemReader<Student>();
xmlFileReader.setResource(new ClassPathResource("/Student.xml"));
xmlFileReader.setFragmentRootElementName("Marks");

Jaxb2Marshaller medicareMarshaller = new Jaxb2Marshaller();
medicareMarshaller.setClassesToBeBound(Student.class);
xmlFileReader.setUnmarshaller(medicareMarshaller);

xmlFileReader.afterPropertiesSet(); // in the case of StaxEventItemReader not really necessary

xmlFileReader.open(new ExecutionContext()); // does some initialisation, so you need to call it

Studen student = null;
while(student = xmlFileReader.read() != null) {
    System.out.println(student...);   
}

xmlFileReader.close();