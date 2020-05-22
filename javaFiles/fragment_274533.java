package org.example;

public class Main {

    public static void main(String[] args)
    {
        Person p1 = new Person("1", "Tom");
        Person p2 = new Person("2", "Jerry");

         //change set is instantiated without any redundant generic parameters
        ChangeSet<StringIdentifier, Person> changes = new ChangeSet<StringIdentifier,Person>();

        //assume that there were some changes and you want to add them to the changeset.
        changes.addChange(p1);
        changes.addChange(p2);

        //retrieve element from the changeset for an id

        p1= changes.getChangedElementForId(new StringIdentifier("1"));
        p2 = changes.getChangedElementForId(new StringIdentifier("2"));


    }
}