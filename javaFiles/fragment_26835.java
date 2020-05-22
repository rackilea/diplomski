package be.chillworld;

import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;

/**
 *
 * @author chillworld
 */
public class IndexVm {

    private List<Person> persons;
    int i;

    public IndexVm() {
        System.out.println("starting creating list");
        persons = new ArrayList<Person>();
        for (i = 0; i < 100; i++) {
            Person person = new Person(i);
            person.addChild(new Person(++i));
            persons.add(person);
        }
        System.out.println("ending creating list");

    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Command
    public void showIndex(@BindingParam("person") Person person) {
        System.out.println("changed name");
        person.setNaam("Chillworld");
        BindUtils.postNotifyChange(null, null, person, "naam");
    }

    @Command
    public void addChild(@BindingParam("person") Person person) {
        System.out.println("add child");
        Person child = new Person(++i);
        child.setNaam("new child");
        person.addChild(child);
        BindUtils.postNotifyChange(null, null, person, "childs");
    }
}