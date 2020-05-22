double divisor = 2.4;
double factor = 100/divisor;
Random rand = new Random();
int maxValue = 1000;
double ERROR = 1e-14*maxValue;

for(int i=0;i<100;i++) {
long randNum;
do {
   randNum = rand.nextInt(maxValue+1);
    if (Math.abs(randNum * factor - (long) (randNum * factor)) > ERROR)
        System.out.println("reject "+randNum + " => "+randNum/divisor);
} while(Math.abs(randNum * factor - (long) (randNum * factor)) > ERROR);
System.out.println(randNum + " => "+randNum/divisor);