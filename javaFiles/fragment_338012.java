/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package person;


public class Student extends Person {

    public int idNumber;

    Student(String name, int idNumber) {
        super(name);
        this.idNumber = idNumber;
    }

    public void setID(int id)
    {
        idNumber = id;
    }

    public int getID()
    {
        return idNumber;
    }

}