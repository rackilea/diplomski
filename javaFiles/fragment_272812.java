char[] sea = new char[10];
for(int x=0; x<sea.length; x++)
    sea[x] = '.';  //set everything as sea first

Random rnd = new Random();
sea[rnd.nextInt(sea.length)] = 's';  //sea ship at random position