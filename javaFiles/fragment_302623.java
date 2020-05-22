private Random random = new Random();
public Tree(int addition) {

    int randomNum = random.nextInt(2); // this will be 0 or 1
    spawn = randomNum;                 // this will NOT BE RANDOM
}