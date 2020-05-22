package de.scrum_master.app;

import java.util.ArrayList;
import java.util.List;

public class Application {
    List<Object> myList = new ArrayList<>();

    public void addToMyList(Object element) { reallyAddToMyList(element); }
    private void reallyAddToMyList(Object element) { myList.add(element); }

    public static void main(String[] args) {
        Application application = new Application();
        application.myList.add("foo");
        application.myList.add(new MyEntity());
        application.addToMyList("bar");
        application.addToMyList(new MyEntity());
    }
}