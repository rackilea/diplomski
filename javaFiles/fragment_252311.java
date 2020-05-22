class RandomNumber{
     Random rand = new Random();
     int randNum = rand.nextInt(12) + 1;
     void Roll(){
        randNum = rand.nextInt(12) + 1;
     }
}