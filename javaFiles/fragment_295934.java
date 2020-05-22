import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "mbean")
@ViewScoped
public class TestBean implements Serializable {

    private List<Person> personList;
    private Person selectedPerson;

    public TestBean() {
        personList = new ArrayList<Person>();
        personList.add(new Person("AKN", "UK"));
        personList.add(new Person("AKF", "Australia"));
        personList.add(new Person("AKH", "Asia"));

    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        System.out.println("selected" + selectedPerson.getName());
        this.selectedPerson = selectedPerson;
    }

}