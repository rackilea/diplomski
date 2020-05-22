import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        // Setting up test environment
        Player player = new Player("Borrie", new int[]{0,0,0,0, 230});
        int itemCost = 16626;
        // Pay for item
        System.out.printf("First we check if the player can pay with it's current ChipSet");
        if (!player.canPayWithChipSet(player.getChips(), 5)) {
            if (player.exchangeChips(5)) {
                System.out.printf("\n\nThe players ChipSet:" + Arrays.toString(player.getChips().chips));
                System.out.printf("\nThe players ChipSet has been succesfully exchanged.");
            } else {
                System.out.printf("\n\nThe players ChipSet:" + Arrays.toString(player.getChips().chips));
                System.out.printf("\nThe players ChipSet was not able to be exchanged.\n");
            }
        } else {
            System.out.printf("\n\nThe player can pay exact with it's original ChipSet. No need to exchange.");
        }

    }
}