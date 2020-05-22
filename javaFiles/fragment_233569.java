package de.scrum_master.aop.aspect;

import java.util.Random;
import de.scrum_master.aop.app.ValidateName;

public aspect NameValidator {
    void validate(String name) {
        if (new Random().nextBoolean())
            throw new RuntimeException("Invalid name " + name);
    }

    void around(String name) : set(@ValidateName * *.*) && args(name) {
        //System.out.println(thisJoinPointStaticPart);
        System.out.print("Validating name " + name);
        try {
            validate(name);
            System.out.println(" -> OK");
            proceed(name);
        }
        catch (Exception e) {
            name = name.toUpperCase();
            System.out.println(" -> " + e.getMessage() + " -> replaced by " + name);
            proceed(name);
        }
    }
}