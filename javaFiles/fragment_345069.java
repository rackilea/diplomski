package com.example.editlistinvaadin;

import java.io.Serializable;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Person implements Serializable
{
    public interface PROPERTY
    {
        public static final String NAME = "name";
        public static final String UUID = "uuid";
        public static final String MODIFIED = "modified";
    }

    private String name = null;
    private String uuid = null;
    private String modified = null;

    // Constructor
    public Person ( String nameArg )
    {
        this.uuid = java.util.UUID.randomUUID().toString();
        this.modified = new DateTime( 2000 , 1 , 1 , 0 , 0 , 0 , 0 , DateTimeZone.UTC ).toString();  // Hard-coding this bogus value for easier reading during experiment.
        this.name = nameArg;
    }

    /**
     * @return the name
     */
    public String getName ()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName ( String name )
    {
        System.out.println( "Person object – SETTING 'name' FROM " + this.name + " TO " + name );
        this.name = name;
        String old = this.modified;
        // Calling setter rather than directly assigning value to the member variable so as to enable logging of this action.
        this.setModified( DateTime.now( DateTimeZone.UTC ).toString() );
    }

    /**
     * @return the id
     */
    public String getUuid ()
    {
        return this.uuid;
    }

    /**
     * @param uuid the id to set
     */
    // Change "public" to "private" to make this a read-only field in Vaadin layout.
    private void setUuid ( String uuid )
    {
        System.out.println( "Person object – SETTING 'uuid' FROM " + this.uuid + " TO " + uuid );
        this.uuid = uuid;
    }

    /**
     * @return the modified
     */
    public String getModified ()
    {
        return modified;
    }

    /**
     * @param modified the modified to set
     */
    // Change "public" to "private" to avoid FieldGroup re-setting old value. Has another effect: Makes this a read-only field in Vaadin layout.
    public void setModified ( String modified )
    {
        System.out.println( "Person object – SETTING 'modified' FROM " + this.modified + " TO " + modified );
        this.modified = modified;
    }

    @Override
    public String toString ()
    {
        return "Person{" + "name=" + this.name + ", uuid=" + this.uuid + ", modified=" + this.modified + '}';
    }

}