package com.howtodoinjava.xml.sax;

/**
 * Model class. Its instances will be populated using SAX parser.
 * */
public class User
{
    //XML attribute id
    private int id;
    //XML element name
    private String Name;
    //XML element surname
    private String SurName;
    //...

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public String getSurName() {
        return SurName;
    }
    public void setSurName(String SurName) {
        this.SurName = SurName;
    }

    // [...]

    @Override
    public String toString() {
        return this.id + ":" + this.Name +  ":" +this.SurName ;
    }
}