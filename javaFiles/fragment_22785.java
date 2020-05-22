private static class Timing {
    public long load=0;
    public long sort=0;
    public long solve1=0;
    public long solve2=0;
    private String secs(long millis) {
        return String.format("%3d.%03ds", millis/1000, millis%1000);
    }
    public String toString() {
        return "  Load: " + secs(load) + "\n  Sort: " + secs(sort) + "\nLinear: " + secs(solve1) + "\nBinary: " + secs(solve2);
    }
    public void add(Timing timing) {
        load+=timing.load;
        sort+=timing.sort;
        solve1+=timing.solve1;
        solve2+=timing.solve2;
    }
}

static Timing test_01() throws FileNotFoundException {
    Timing timing=new Timing();
    long start = System.currentTimeMillis();
    final File file = new File("c:\\path\\to\\xnpwdiG3.txt");
    final Scanner scanner = new Scanner(file);
    int[] houseLocations = new int[73382];
    for (int counter = 0; counter < 73382; counter++) {
        houseLocations[counter] = scanner.nextInt();
    }
    timing.load+=System.currentTimeMillis()-start;
    start=System.currentTimeMillis();
    final int[] uniqueHouseLocationsSorted = HackerlandRadioTransmitters.uniqueHouseLocationsSorted(houseLocations);
    timing.sort=System.currentTimeMillis()-start;
    start=System.currentTimeMillis();
    final int minNumOfTransmitters = HackerlandRadioTransmitters.minNumOfTransmitters(uniqueHouseLocationsSorted, 73381, false);
    timing.solve1=System.currentTimeMillis()-start;
    start=System.currentTimeMillis();
    final int minNumOfTransmittersBin = HackerlandRadioTransmitters.minNumOfTransmitters(uniqueHouseLocationsSorted, 73381, true);
    timing.solve2=System.currentTimeMillis()-start;
    final long end = System.currentTimeMillis();
    return timing;
}