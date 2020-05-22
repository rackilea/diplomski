package be.chillworld;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chillworld
 */
public class Person {
    private int id;
    private String naam;
    private List<Person> childs = new ArrayList<Person>();

    public Person(int id) {
        this.id = id;
        naam = "test " + id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        System.out.println("asked getter (naam) of "+ id);
        return naam;
    }

    public List<Person> getChilds() {
        System.out.println("asked getter (childs) of "+ id);
        return childs;
    }

    public void setChilds(List<Person> childs) {
        this.childs = childs;
    }

    public boolean addChild(Person person) {
        return childs.add(person);
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + getNaam() + '}';
    }
}