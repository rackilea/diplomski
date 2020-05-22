Random rand = new Random();
Set<Integer> randSet = new TreeSet<>();
for (int x = 0; x < 20; x++){
    int randomNum = rand.nextInt(20) + 1;
    randSet.add(randomNum);
    System.out.println(randomNum);
}
for (Integer randomNum: randSet) {
    System.out.println(randomNum);
}