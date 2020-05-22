import java.util.ArrayList;
import java.util.Arrays;

public class Player {

    private String name;
    private ChipSet chips;
    private int points = 0;

    public Player(String name, int[] chips) {
        this.name = name;
        this.chips = new ChipSet(chips);
        this.points = this.chips.getSum();
    }

    public boolean exchangeChips(int cost) {
        ChipSet newChipSet = exchangePlayerChipSet(this.chips.getChips(), cost);
        if (newChipSet == null) {
            return false;
        } else {
            this.chips = newChipSet;
            return true;
        }
    }

    public ChipSet exchangePlayerChipSet(int[] originalChipValues, int cost) {
        ChipSet newChipSet = null;
        // Create possible combinations to compare
        ArrayList<ChipSet> chipSetCombos = createCombinations(this.chips.getChips());
        // Filter the chipset based on if it's able to pay without changing chips
        System.out.printf("\n\n---- Filter which of these combinations are able to be payed with without changing chips ----");
        ArrayList<ChipSet> filteredCombos = filterCombinations(chipSetCombos, cost);
        // Compare the filtered chipsets to determine which one has changed the least
        if (!filteredCombos.isEmpty()) {
            newChipSet = compareChipSets(originalChipValues, filteredCombos);
        }
        return newChipSet;
    }

    private ArrayList<ChipSet> createCombinations(int[] array) {
        ArrayList<ChipSet> combos = new ArrayList<>();
        int[] startCombo = array;
        System.out.printf("Player has " + getTotalPoints(startCombo) + " points in chips.");
        System.out.printf("\nPlayer has these chips (WHITE,RED,GREEN,BLUE,BLACK): " + Arrays.toString(startCombo));

        while (startCombo[4] != 0) {
            startCombo = lowerBlack(startCombo);
            if (getTotalPoints(startCombo) == points) {
                combos.add(new ChipSet(startCombo));
            }
        }
        while (startCombo[3] != 0) {
            startCombo = lowerBlue(startCombo);
            if (getTotalPoints(startCombo) == points) {
                combos.add(new ChipSet(startCombo));
            }
        }
        while (startCombo[2] != 0) {
            startCombo = lowerGreen(startCombo);
            if (getTotalPoints(startCombo) == points) {
                combos.add(new ChipSet(startCombo));
            }
        }
        while (startCombo[1] != 0) {
            startCombo = lowerRed(startCombo);
            if (getTotalPoints(startCombo) == points) {
                combos.add(new ChipSet(startCombo));
            }
        }
        System.out.printf("\n\n---- Creating variations on the players chips ----");
        System.out.printf("\nVariation (all worth " + getTotalPoints(startCombo) + " points):\n");
        int teller = 1;
        for (ChipSet a : combos) {
            System.out.printf("\nCombo " + teller + ": " + Arrays.toString(a.getChips()));
            teller++;
        }
        return combos;
    }

    private ArrayList<ChipSet> filterCombinations(ArrayList<ChipSet> combinations, int cost) {
        ArrayList<ChipSet> filteredChipSet = new ArrayList<>();
        combinations.stream().filter((cs) -> (canPayWithChipSet(cs, cost))).forEach((cs) -> {
            filteredChipSet.add(cs);
        });
        return filteredChipSet;
    }

    // This method has be worked out
    public boolean canPayWithChipSet(ChipSet cs, int cost) {
        ChipSet csOrig = new ChipSet(cs.chips);
        ChipSet csCopy = new ChipSet(cs.chips);
        int counterWhite = 0;
        int counterRed = 0;
        int counterGreen = 0;
        int counterBlue = 0;
        int counterBlack = 0;

        while (20 <= cost && cost > 0 && csOrig.getChips()[4] != 0) {
            csOrig.getChips()[4] -= 1;
            cost -= 20;
            counterBlack++;
        }
        while (10 <= cost && cost > 0 && csOrig.getChips()[3] != 0) {
            csOrig.getChips()[3] -= 1;
            cost -= 10;
            counterBlue++;
        }
        while (5 <= cost && cost > 0 && csOrig.getChips()[2] != 0) {
            csOrig.getChips()[2] -= 1;
            cost -= 5;
            counterGreen++;
        }
        while (2 <= cost && cost > 0 && csOrig.getChips()[1] != 0) {
            csOrig.getChips()[1] -= 1;
            cost -= 2;
            counterRed++;
        }
        while (1 <= cost && cost > 0 && csOrig.getChips()[0] != 0) {
            csOrig.getChips()[0] -= 1;
            cost -= 1;
            counterWhite++;
        }
        if (cost == 0){
            System.out.printf("\nCombo: %s can pay exact. With %d white, %d red, %d green, %d blue an %d black chips", Arrays.toString(csCopy.chips),counterWhite,counterRed,counterGreen,counterBlue,counterBlack);
            return true;
        } else {
            System.out.printf("\nCombo: %s cannot pay exact.\n\n\n", Arrays.toString(csCopy.chips));
            return false;
        }    
    }

    private ChipSet compareChipSets(int[] originalChipValues, ArrayList<ChipSet> chipSetCombos) {
        ChipSet newChipSet;
        int[] chipSetWaardes = originalChipValues; // originele chipset aantal van kleur
        int[] chipSetCombosDifferenceValues = new int[chipSetCombos.size()];
        int teller = 1;

        System.out.printf("\n\n---- Calculate differences between players stack and it's variations ----");
        for (ChipSet cs : chipSetCombos) {
            int aantalWhite = cs.getChips()[0];
            int aantalRed = cs.getChips()[1];
            int aantalGreen = cs.getChips()[2];
            int aantalBlue = cs.getChips()[3];
            int aantalBlack = cs.getChips()[4];
            int differenceWhite = Math.abs(chipSetWaardes[0] - aantalWhite);
            int differenceRed = Math.abs(chipSetWaardes[1] - aantalRed);
            int differenceGreen = Math.abs(chipSetWaardes[2] - aantalGreen);
            int differenceBlue = Math.abs(chipSetWaardes[3] - aantalBlue);
            int differenceBlack = Math.abs(chipSetWaardes[4] - aantalBlack);
            int totalDifference = differenceWhite + differenceRed + differenceGreen + differenceBlue + differenceBlack;
            chipSetCombosDifferenceValues[teller - 1] = totalDifference;
            System.out.printf("\nCombo " + teller + ": " + Arrays.toString(cs.getChips()) + " = " + totalDifference);
            teller++;
        }
        newChipSet = chipSetCombos.get(smallestValueOfArrayIndex(chipSetCombosDifferenceValues));
        System.out.printf("\n\nThe least different ChipSet is: " + Arrays.toString(newChipSet.getChips()) + " ");
        return newChipSet;
    }

    private int smallestValueOfArrayIndex(int[] array) {
        int huidigeWaarde = array[0];
        int smallestIndex = 0;
        for (int j = 1; j < array.length; j++) {
            if (array[j] < huidigeWaarde) {
                huidigeWaarde = array[j];
                smallestIndex = j;
            }
        }
        return smallestIndex;
    }

    private int[] lowerBlack(int[] array) {
        return new int[]{array[0], array[1], array[2], array[3] + 2, array[4] - 1};
    }

    private int[] lowerBlue(int[] array) {
        return new int[]{array[0], array[1], array[2] + 2, array[3] - 1, array[4]};
    }

    private int[] lowerGreen(int[] array) {
        return new int[]{array[0] + 1, array[1] + 2, array[2] - 1, array[3], array[4]};
    }

    private int[] lowerRed(int[] array) {
        return new int[]{array[0] + 2, array[1] - 1, array[2], array[3], array[4]};
    }

    private int getTotalPoints(int[] array) {
        return ((array[0] * 1) + (array[1] * 2) + (array[2] * 5) + (array[3] * 10) + (array[4] * 20));
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    public ChipSet getChips() {
        return chips;
    }

}