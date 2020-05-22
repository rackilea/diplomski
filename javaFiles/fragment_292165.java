public class BeanContainer{
    private ArrayList<School> schools = new ArrayList<School>();
    private ArrayList<Car> cars = new ArrayList<Car>;
    private ArrayList<Person> people = ArrayList<Person>(); 

 public void addSchool(School school){
    this.schools.add(school);
}

public void addSchoolCollection(ArrayList<School> schools){
    this.schools.add(schools);
}

public ArrayList<School> getSchoolCollection(){
    return schools;
}

...


 }