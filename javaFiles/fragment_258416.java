import java.util.*;
import java.util.stream.*;

interface HeavyWeightInterface {
    public String myToString();
}

class ConcreteHeavyWeight implements HeavyWeightInterface {
    private static final int NUMBER_OF_OBJECTS = 100000;
    // non DB heavy class
    private String base;
    private List<String> dummyObjects;

    public ConcreteHeavyWeight(String keyBase) {
        this.base = keyBase;
        this.dummyObjects = new ArrayList<>();
        IntStream.range(0, NUMBER_OF_OBJECTS).forEach(
           nbr -> { 
               dummyObjects.add(base + " : " + nbr);
           });
    }

    public String myToString() {
        return "My base is : " + base + " with an internal DS of " + dummyObjects.size() + " entities";
    }
}

interface HeavyWeightFactory {
    public HeavyWeightInterface build(String key);
}

class ConcreteHeavyWeightFactory implements HeavyWeightFactory{
    public HeavyWeightInterface build(String key) {
        return new ConcreteHeavyWeight(key);
    }
}

class IdentityMap {

    private Map<String,HeavyWeightInterface> internalMap;
    private HeavyWeightFactory hwfactory;
    public IdentityMap(HeavyWeightFactory hwfactory) {
        this.internalMap = new HashMap<>();
        this.hwfactory = hwfactory;
    }
    public HeavyWeightInterface retreive(String key) {
        if(!internalMap.containsKey(key)) {
            internalMap.put(key,hwfactory.build(key));
        }
        return internalMap.get(key);
    }

}

public class MyClass {
    public static void main(String[] args){
        IdentityMap im = new IdentityMap(new ConcreteHeavyWeightFactory());
        HeavyWeightInterface hw0 = im.retreive("Test0");
        im.retreive("Test1");
        im.retreive("Test2");
        im.retreive("Test3");
        HeavyWeightInterface hw1 = im.retreive("Test0");
        System.out.println("First call with Test0 key = " + hw0 + ", Second call with Test0 key = " + hw1);
        System.out.println(hw1.myToString());
    }
}