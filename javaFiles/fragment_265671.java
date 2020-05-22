static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
    int appleCount = 0;
    int orangeCount = 0;
    for(int i:apples){
        if(s<=i+a && i+a<=t)
            appleCount++;
    }
    for (int j : oranges) {
        if (s <= j + b && j+b <= t)
            orangeCount++;
    }
    System.out.println(appleCount);
    System.out.println(orangeCount);

}