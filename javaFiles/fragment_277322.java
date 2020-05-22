import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SomeClass{
    // suppose the fields in your class
    String name, rank;

    // simple constructor
    public SomeClass(String name, String rank){
        this.name = name;
        this.rank = rank;
    }


    // you need to override both equals and hashCode methods from
    // Object superclass in order the set works properly and realizes 
    // that two given objects of type SomeClass are equal
    @Override
    public boolean equals(Object other){
        if(other==null) return false;
        if (other == this) return true;
        return ((SomeClass)other).name.equalsIgnoreCase(this.name)
               && ((SomeClass)other).rank.equalsIgnoreCase(this.rank);
    }


    @Override
     public int hashCode() {
         return Objects.hash(name, rank);
     }


    @Override
    public String toString(){
        return name + " " + rank;
    }

    /**
     * Pass a set then add the items to a temporary ArrayList
     * to be sorted according to the Comparator condition
     * then clear the set and add the sorted element back
     * @param list
     */
    public static void sort(Set<SomeClass> list){
        List<SomeClass> temp = new ArrayList<>();
        temp.addAll(list);
        // anonymous class implementation of Comparator
        Collections.sort(temp, new Comparator<SomeClass>(){

                @Override
                public int compare(SomeClass obj1, SomeClass obj2) {
                    // if two objects' ranks are the same 
                    if(obj1.rank.equals(obj2.rank)){
                        // then compare their names
                        return obj1.name.compareTo(obj2.name);
                    }
                    else{
                        return obj1.rank.compareTo(obj2.rank);
                    }
                }});

        list.clear();
        list.addAll(temp);  
    }


    // testing
    public static void main(String[] args) {
        // create Objects of the class with duplicate
        SomeClass obj1 = new SomeClass("john", "colonel");
        SomeClass obj2 = new SomeClass("XXX", "major"); 
        SomeClass obj3 = new SomeClass("Roy", "general");
        SomeClass obj4 = new SomeClass("derrick", "no Rank");
        SomeClass obj5 = new SomeClass("john", "something");
        SomeClass obj6 = new SomeClass("Alex", "major");
        SomeClass obj7 = new SomeClass("Alex", "major"); // duplicate object


        // LinkedHashSet PRESERVES the order of elements' insertion
        // in addition to removing duplicates
        Set<SomeClass> list = new LinkedHashSet<>();

        // populate the set
        list.add(obj1); list.add(obj2); list.add(obj3);
        list.add(obj4); list.add(obj5); list.add(obj6);
        list.add(obj7);

        //before sorting
        System.out.println("Before " + list);

        // after sorting
        sort(list);
        System.out.println("After " + list);

    }
}