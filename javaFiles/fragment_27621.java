public class PersonAction extends ActionSupport implements SessionAware {

  private Person person = new Person();

  public Person getPerson() {
    return person;
  }

  public setPerson(Person person){
    this.person = person;
  }

  private Map<String, Object> session;

  public setSession(Map<String, Object> session){
    this.session = session;
  }

  public String execute() { //Create persons
    List<Person> personList = (List<Person>) session.get("personList");
    for (Person p : personList)
     getPersonService().save(p); // save to db
    //clear the list
    personList.clear();
    return SUCCESS;
  }

  public String add() { //Add person
    List<Person> personList = (List<Person>) session.get("personList");
    if (personList == null) {
      personList = new ArrayList<Person>();
      session.put("personList", personList);
    }
    personList.add(person);
    return SUCCESS;

  }

}