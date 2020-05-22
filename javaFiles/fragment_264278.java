ArrayList<Integer> randomList = new ArrayList<>();
Random rand = new Random();

for (int i = 0; i < p.length; i++) {
    for (int i = 0; i < p[i].length; i++) {

            int randomNum = rand.nextInt((300 - 1) + 1) + 1;

            while (randomList.contains(randomNum)) {
                randomNum = rand.nextInt((300 - 1) + 1) + 1;
            }

            excludedNumbers.remove((Integer) randomNum); // the new line
            randomList.add(randomNum);
    }
}