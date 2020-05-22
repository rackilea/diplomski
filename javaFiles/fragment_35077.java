package project;

import java.util.ArrayList;

public class ListOfNames
{   
    private static ArrayList<String> list_of_names ;

    public ListOfNames()
    {
        list_of_names = new ArrayList<>();
        list_of_names.add("A");
        list_of_names.add("B");
        list_of_names.add("C");
        list_of_names.add("D");
        list_of_names.add("E");
        list_of_names.add("F");
        list_of_names.add("G");
        list_of_names.add("H");
        list_of_names.add("I");
        list_of_names.add("J");
        list_of_names.add("K");
        list_of_names.add("L");
        list_of_names.add("M");
        list_of_names.add("N");
        list_of_names.add("O");
        list_of_names.add("P");
        list_of_names.add("Q");
        list_of_names.add("R");
        list_of_names.add("S");
        list_of_names.add("T");
        list_of_names.add("U");
        list_of_names.add("V");
        list_of_names.add("W");
        list_of_names.add("X");
        list_of_names.add("Y");
        list_of_names.add("Z");

    }


    public static ArrayList<String> getlist() {
        return list_of_names;
    }
}