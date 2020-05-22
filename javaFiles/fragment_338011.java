/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author Administrator
 */
public class Person {

    /**
     * @param args the command line arguments
     */

    private String name;

    public Person(String n)
    {
        name = n;
    }

    public void setName(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }
}