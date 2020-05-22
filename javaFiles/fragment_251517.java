public class Solution {
    public static void main(String[] args) {
        BuyAHouseInc jane = new BuyAHouseInc("jane", "doe", "123 main street", 100000);
        BuyAHouseInc john = new BuyAHouseInc("john", "doe", "123 main street", 50000);

        System.out.println("The following clients can afford to buy a house");

        if (canAffordTheHouse(jane)) {
            jane.displayClient();
        }
        if (canAffordTheHouse(john)) {
            john.displayClient();
        }
    }

    public static boolean canAffordTheHouse(BuyAHouseInc client) {
        return client.getBudget() > 50000;
    }
}