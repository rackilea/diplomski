import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


    public class StackTest {
        public static void main(String[] args) {
            Person person = new Person("Logan");
            Person person2 = new Person("Jean");
            Person person3 = new Person("Gambit");
            Person person4 = new Person("Storm");

            Item item1 = new Item("Claws");
            Item item2 = new Item("Jacket");
            Item item3 = new Item("Cards");
            Item item4 = new Item("Cape");

            List<Item> items = new ArrayList<Item>();
            items.add(item1);
            items.add(item2);
            items.add(item3);
            items.add(item4);

            List<Item> loganItems = new ArrayList<Item>(items);
            List<Item> jeanItems = new ArrayList<Item>(items);
            List<Item> gambitItems = new ArrayList<Item>(items);
            List<Item> stormItems = new ArrayList<Item>(items);

            Map<Person, List<Item>> people = new HashMap<Person,List<Item>>();
            people.put(person, loganItems);
            people.put(person2, jeanItems);
            people.put(person3, gambitItems);
            people.put(person4, stormItems);

            printMap(people);

            List<Item> removeItems = new ArrayList<Item>();
            Item rItem1 = new Item("Cards");
            Item rItem2 = new Item("Jacket");
            removeItems.add(rItem1);
            removeItems.add(rItem2);

            removeItem(people, person, removeItems);

            printMap(people);

        }

        public static void removeItem(Map<Person,List<Item>> map, Person p, List<Item> items){
            map.get(p).removeAll(items);
        }

        public static void printMap(Map<Person, List<Item>> map){
            for(Entry<Person,List<Item>> entry:map.entrySet()){
                System.out.println(entry.getKey().getName() + " items:");
                for(Item item: entry.getValue()){
                    System.out.println(item.getName());
                }
            }
        }
    }