public class PersonContainer {

private String id;

private Person person;
private PersonDetail personDetail;
private List<PersonAddDetail> personAddDetailList = new ArrayList<>();

public PersonContainer(Person person) {
  this.id = person.getID();
  this.person = person;
}



public PersonContainer(PersonDetail personDetail) {
    this.id = personDetail.getOTTRID();
    this.personDetail = personDetail;
  }

  public PersonContainer(PersonAddDetail personAddDetail) {
    this.id = personAddDetail.getOTTRID();
    this.timeStamp = ttrDetailAddEvent.getDATECREATED();
    this.personAddDetailList.add(personAddDetail);
  }

  public PersonContainer merge(PersonContainer other) {
    if (other.person != null) {
      this.person = other.person;
      return this;
    }
    if (other.personDetail != null) {
      this.personDetail = other.personDetail;
      return this;
    }
    if (other.personAddDetailList.size() > 0) {
      this.personAddDetailList.addAll(other.personAddDetailList);
      return this;
    }
    return null;
  }

  public String getId() {
    return id;
  }

  public Person getPerson() {
    return person;
  }

  public PersonDetail getPersonDetail() {
    return personDetail;
  }

  public List<PersonAddDetail> getPersonAddDetailList() {
    return PersonAddDetailList;
  }

  public boolean isComplete() {
    return person != null && personDetail != null && personAddDetailList.size() > 1;
  }
}