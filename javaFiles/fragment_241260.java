Random r = new Random();

float probability = r.nextFloat(); // get a value between 0 and 1
if (probability < probabilityOfSix){
    return 6;
} else {
    return r.nextInt(4) +1;
}