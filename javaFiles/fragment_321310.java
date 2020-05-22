package test.nashorn;

import java.util.HashMap;

import jdk.nashorn.api.scripting.AbstractJSObject;

public class NSomeOtherBean extends AbstractJSObject {

    /**
     * The current values for this object.
     */
    private HashMap<String, Object> values = new HashMap<>();

    public NSomeOtherBean() {
        System.out.println("Constructor called.");
    }

    // do you have a property of that given name?
    @Override
    public boolean hasMember(String name) {
        return has(name);
    }

    // get the value of that named property
    @Override
    public Object getMember(String name) {

        return get(name);

    }

    // get the value of that named property
    @Override
    public void setMember(String name,Object value) {

         put(name,value);

    }

    public Object get(String name) {

        System.out.println("JAVA Get is called.");
        // System.out.println("Called for this"+name+" and returned
        // :"+values.get(name));

        return values.get(name);
    }

    public void put(String name, Object value) {
        System.out.println("JAVA Put is called. Input name: " + name + "\n Input values: " + value);

        values.put(name, value);

    }

    public boolean has(String name) {
        System.out.println("JAVA Has is called. Input name: " + name);

        return values.containsKey(name);

    }
}