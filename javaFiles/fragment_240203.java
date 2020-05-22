package com.googlecode.cqengine.examples.nestedobjects;

import com.googlecode.cqengine.*;
import com.googlecode.cqengine.attribute.*;
import com.googlecode.cqengine.query.option.QueryOptions;
import java.util.*;
import static com.googlecode.cqengine.query.QueryFactory.*;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

public class NestedObjectsExample {

    public static void main(String[] args) {
        Order order1 = new Order(asList(new Product("Diet Coke"), new Product("Snickers Bar")));
        Order order2 = new Order(singletonList(new Product("Sprite")));
        User user1 = new User(1, asList(order1, order2));

        Order order3 = new Order(asList(new Product("Sprite"), new Product("Popcorn")));
        User user2 = new User(2, singletonList(order3));

        Order order4 = new Order(singletonList(new Product("Snickers Bar")));
        User user3 = new User(3, singletonList(order4));

        IndexedCollection<User> users = new ConcurrentIndexedCollection<>();
        users.addAll(asList(user1, user2, user3));

        users.retrieve(equal(PRODUCT_NAMES_ORDERED, "Snickers Bar")).forEach(user -> System.out.println(user.userId));
        // ...prints 1, 3
    }

}