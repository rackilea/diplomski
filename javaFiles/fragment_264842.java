public class Szymon {

    public static String reply(String name) {
        switch(name){
        case "michal":name="Niedzwiedz!";
              break;
        default:name = "wot ?";
        }
        // Return the value to be applied...
        return name;
     }

    public static void greet(String name){
        System.out.printf("Elo %s co tam u ciebie ? \n",name);
    }
}