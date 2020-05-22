List<Integer> randomNumbersList = new LinkedList<Integer>();
int cur = -1;
double p = probability / 100;
double q = 1 - p;
double lnq = Math.log(q);
Random random = new Random();
while (true) {
    double u = random.nextDouble();
    cur = cur + 1 + (int)Math.floor(Math.log(u) / lnq);
    if (cur >= MAX)
        break;
    randomNumbersList.add(cur);
}