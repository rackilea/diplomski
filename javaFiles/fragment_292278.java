package com.guds.test;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;

    @JsonIgnoreProperties("user")
    List<Car> cars;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.cars = new ArrayList<>();
    }

}

package com.guds.test;


public class Car {

    private int id;
    private String name;

    @JsonIgnoreProperties("cars")
    private User user;

    public Car(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }
}