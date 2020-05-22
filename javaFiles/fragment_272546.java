package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;

public class Application {
    List<Object> myList = new ArrayList<>();

    public static void main(String[] args) {
        Application application = new Application();
        application.myList.add("foo");
        application.myList.add(new MyEntity());
        application.myList.add("bar");
        application.myList.add(new MyEntity());
    }
}