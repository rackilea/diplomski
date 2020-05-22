public class ApocalypseNow {

    public static void main(String[] args) {
        int[] population = { 10, 6, 0, 4, 8, 10 };
        int currentValue;
        int diminishedValue;
        int dayCounters = 0;
        while (!areAllDead(population)) {
            for (int i = 0; i < population.length; i++) {
                if (checkNeighbours(i, population)) {
                    currentValue = population[i];
                    diminishedValue = currentValue / 2;
                    population[i] = diminishedValue;
                }
            }

            dayCounters++;
            System.out.print("Day " + dayCounters + ": ");
            printPopulation(population);
        }

    }

    public static boolean checkNeighbours(int currentIndex, int[] population) {
        int leftValue;
        int rightValue;
        try {
            leftValue = population[currentIndex - 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            leftValue = -1;
        }
        try {
            rightValue = population[currentIndex + 1];
        } catch (ArrayIndexOutOfBoundsException e) {
            rightValue = -1;
        }

        if (leftValue == 0 || rightValue == 0)
            return true;
        return false;
    }

    public static void printPopulation(int[] population) {
        for (int i : population) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean areAllDead(int[] population) {
        for (int i = 0; i < population.length; i++) {
            if (population[i] != 0)
                return false;
        }
        return true;
    }

}