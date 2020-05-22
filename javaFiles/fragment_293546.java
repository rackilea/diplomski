package com.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        rows.add("1.2.3.4.5");
        rows.add("1.3.2.4.5");
        rows.add("1.2.4.5.6");

        MyTreeMap root = new MyTreeMap();
        for (String row : rows) {
            MyTreeMap n = root;
            String[] cells = row.split("\\.");
            for (String cell : cells) {
                MyTreeMap child = n.get(cell);
                if (child == null) {
                    n.put(cell, child = new MyTreeMap());
                }
                n = child;
            }
        }

        print(root, "", "-");
    }

    static void print(MyTreeMap m, String indentationStr, String indentationStrAddition) {
        for (Entry<String, MyTreeMap> o : m.entrySet()) {
            System.out.println(indentationStr + o.getKey());
            print(o.getValue(), indentationStr + indentationStrAddition, indentationStrAddition);
        }
    }

    /**
     * This is just a construct that helps us to parameterize recursively.
     */
    static class MyTreeMap extends TreeMap<String, MyTreeMap> {private static final long serialVersionUID = 1L;}
}