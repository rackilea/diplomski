String base = "I have a product that is the product of my hard work." 
  + "Products are always nice, because I can win cash if I sell my products.\n" 
  + "The product of me making my product is cash, because cash is the product of selling my product.\n" 
  + "With the cash I win with my product, I can buy other people's products.";

int processRepeats = 1000000; //One million runs, enough to take time for each clocking.
int averageRepeats = 10;

long averager = 0;
int count = 0;

//Switch the commenting to test the opposing method.
Pattern p = Pattern.compile("products?", Pattern.CASE_INSENSITIVE);
//Pattern p = Pattern.compile("[Pp]roducts?");
Matcher m;
long clocking;
for (int i = 0; i < averageRepeats; i++) {
  clocking = System.nanoTime();
  for (int ii = 0; ii < processRepeats; ii++) {
    m = p.matcher(base); //Here because the "base" would change in a real environment.
    while (m.find()) {
      count++;
    }
  }
  clocking = System.nanoTime() - clocking;
  averager += clocking;
  //System.out.printf("This method found %9d matches in %15d nanos [%9.3f ms]\n", count, clocking, clocking / 1000000f);
}
System.out.printf("This method averages %15d nanos [%16.3f ms] for %d times executing %d runs.\n",
averager / averageRepeats, (averager / (float) averageRepeats) / 1000000f, averageRepeats, processRepeats);

//RESULTS ON MY MACHINE:

//FIRST METHOD: [3 runs to demonstrate/guarantee consistency]
//This method averages      5024404693 nanos [        5024,404 ms] for 10 times executing 1000000 runs.
//This method averages      5021385539 nanos [        5021,386 ms] for 10 times executing 1000000 runs.
//This method averages      5017170143 nanos [        5017,170 ms] for 10 times executing 1000000 runs.

//SECOND METHOD: [same deal]
//This method averages      5806310774 nanos [        5806,311 ms] for 10 times executing 1000000 runs.
//This method averages      5809879747 nanos [        5809,880 ms] for 10 times executing 1000000 runs.
//This method averages      5804277386 nanos [        5804,277 ms] for 10 times executing 1000000 runs.