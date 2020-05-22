import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Test {


    public static void main(String[] args) {

        ArrayList<Names> menu = new ArrayList<Names>();
        menu.add(new Names("chandru","image"));
        menu.add(new Names("vikki","image"));
        menu.add(new Names("karthick","image"));
        menu.add(new Names("chandru","image"));
        menu.add(new Names("karthick","image"));
        menu.add(new Names("chandru","image2"));
        menu.add(new Names("karthick","image"));
        menu.add(new Names("vikki","image"));
        menu.add(new Names("karthick","image"));
        menu.add(new Names("harish","image"));
        menu.add(new Names("vivek","image"));
        menu.add(new Names("harish","image"));

        ArrayList<Names> al = new ArrayList<Names>();

         Set<Names> hs = new HashSet<Names>();
         hs.addAll(menu);

         al.clear();
         al.addAll(hs);

         System.out.println(al);

    }
}