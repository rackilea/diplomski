package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
public class Journey extends Model {

    @Id
    public Integer id;

    public static Finder<Integer, Journey> find
            = new Model.Finder<>(Integer.class, Journey.class);

    // other fields
    public String address;
    public String country;

}