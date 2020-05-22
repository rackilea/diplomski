package intersectioninintegerlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Ahmad
 */
public class IntersectionInIntegerList {

    public static void main(String[] args) {
        List<Pair> lst1 = new ArrayList<>(Arrays.asList(new Pair(1,3), new Pair(11,24)));
        Obj obj1 = new Obj("obj1", lst1);

        List<Pair> lst2 = new ArrayList<>(Arrays.asList(new Pair(3,4), new Pair(5,6), new Pair(12,20)));
        Obj obj2 = new Obj("obj2", lst2);

        List<Pair> lst3 = new ArrayList<>(Arrays.asList(new Pair(30,38)));
        Obj obj3 = new Obj("obj3", lst3);

        List<Obj> objs = new ArrayList<>(Arrays.asList(obj1, obj2, obj3));

        for(int i = 0; i < objs.size(); i++){
            for(int j = i+1; j < objs.size(); j++){
                findIntersect(objs.get(i), objs.get(j));
            }
        }

    }

    private static void findIntersect(Obj o1, Obj o2) {
        System.out.println(o1.name + " - " + o2.name);
        for(Pair p1 : o1.pairs){
            for(Pair p2 : o2.pairs){
                int A = p1.i1;
                int B = p1.i2;
                int X = p2.i1;
                int Y = p2.i2;
                if((A >= X && A <= Y) || (X >= A && X <= B)){
                    System.out.println(o1.name + " intersects with " + o2.name);
                }
            }
        }
    }
}