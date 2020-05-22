import java.util.ArrayList;

public class test {
    private static ArrayList<ArrayList<Foo>> foonetwork = new ArrayList<ArrayList<Foo>>();

    public static void main(String[] args){
        networkoffoos(5);
        updatefoomsg(foonetwork);
    }

    public static void networkoffoos(int numoffoos) {
        for(int i = 0; i < numoffoos; i++) {
            ArrayList<Foo> fooArrayList = new ArrayList<Foo>();
            fooArrayList.add(new Foo(10));
            foonetwork.add(fooArrayList);
        }
    }

    public static void updatefoomsg (ArrayList<ArrayList<Foo>> foonetwork) {
        for(int foolayer = 0; foolayer< foonetwork.size(); foolayer++)
            for(int fooinlayer = 0; fooinlayer< foonetwork.get(foolayer).size(); fooinlayer++)
                for(int msginfoo = 0; msginfoo < foonetwork.get(foolayer).get(fooinlayer).msgstoboo.size(); msginfoo++)
                    foonetwork.get(foolayer).get(fooinlayer).setMsg(msginfoo,3);
    }
}