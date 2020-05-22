public class MainClass {

static List<FlowerClass> flowerPack = new ArrayList<FlowerClass>();
static Map<String, Integer> flowerCount = new HashMap<String, Integer>();

public static void addFlower() {
    if (FlowerClass.numberFlowers() == 25) {
        System.out.println("There are 25 flowers in the flowerpack. Remove at least one in order to add more.");
        return;
    }
    Scanner input = new Scanner(System.in);
    System.out.println("What is the flower's name?");
    String desiredName = input.nextLine();
    System.out.println("What is the flower's color?");
    String desiredColor = input.nextLine();
    System.out.println("How many thorns does it have?");
    Scanner input2 = new Scanner(System.in);
    int desiredThorns = input2.nextInt();
    System.out.println("What does it smell like?");
    String desiredSmell = input.nextLine();
    flowerPack.add(new FlowerClass(desiredName, desiredColor, desiredThorns, desiredSmell));
    if(!flowerCount.containsKey(desiredName))
    {
        flowerCount.put(desiredName, 1);
    }
    else
    {
        int currentCount = flowerCount.get(desiredName);
        flowerCount.put(desiredName, currentCount+1));
    }
}