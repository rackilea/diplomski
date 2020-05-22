@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    private String name;
    private String telephone;

    public Person() {
        super();
    }

    public Person(String name, String telephone){
        this();
        setName(name);
        setTelephone(telephone);
    }

    public String getName(){
        return name;
    }
    public String getTelephone(){
        return telephone;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }
}

    @XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
    private String name;
    private String telephone;

    public Company() {
        super();
    }

    public Company(String name, String telephone){
        this();
        setName(name);
        setTelephone(telephone);
    }

    public String getName(){
        return name;
    }
    public String getTelephone(){
        return telephone;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setTelephone(String telephone){
        this.telephone=telephone;
    }

}

    @XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FileTest2 {

    private Person person;
    private Company company;

    public FileTest2() {
        super();
    }

    public FileTest2(Person person, Company company){
        this();
        setPerson(person);
        setCompany(company);
    }

    public Person getPerson() {
        return this.person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }   
}

        @Test
    public void testUnMarshal() throws Exception {
        File xmlFile = null;
        try {
            xmlFile = getXmlFile();
        } catch (Exception e) {
        }
        if (xmlFile == null) {
            fail("file not found");
        }
        FileTest2 filetest = (FileTest2) JaxbUtil.unmarshal(
                xmlFile, filetest.class,
                FileTest2.class, Person.class, Company.class);
        if (filetest==null){
            fail("unmarshal failed");
        }
        assertEquals("Company name was not correctly handled","Test2",filetest.getCompany().getName());
        assertEquals("Company telephone was not correclty handled","181", filetest.getCompany().getTelephone());
        assertEquals("Person name was not correctly handled","Test",filetest.getPerson().getName());
        assertEquals("Person telephone was not correclty handled","190", filetest.getPerson().getTelephone());

    }

        @Test
    public void testMarshal() throws Exception {
        Person person = new Person("bob", "23");
        Company company = new Company("accountTemps", "99");
        FileTest2 filetest = new FileTest2(person, company);
        FileWriter fileWriter = new FileWriter("marshaledFileResults.xml");
        JaxbUtil.marshal(filetest, fileWriter, true, filetest.class,
                FileTest2.class, Person.class, Company.class);
    }