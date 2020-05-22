double[] gens = {100, 200.1, 9.3, 10};

int[] count = new int[10];

for (double d : gens)
    count[("" + Math.abs(d)).charAt(0) - '0']++;

for (int n : count)
    System.out.println((double)n / gens.length);