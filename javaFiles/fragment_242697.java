boolean kontroll = true;
long limit = 10;
long checker = 2;
long sum = 0;

while (checker < 10) {
    if (checker != 2 && checker % 2 == 0) { // move this check out of the loop and correct condition
        kontroll = false;
    } else {
        long max = (long)Math.sqrt(checker);
        for (long i = 3; i <= max; i += 2) { // change < to <=
            if (checker % i == 0) {
                kontroll = false;
                break; // add break for better performance
            } 
        }
    }
    if (kontroll) {
        sum += checker; 
        System.out.println("Prim: " + checker);
    }
    checker++;
    kontroll = true;
}
System.out.println(sum);