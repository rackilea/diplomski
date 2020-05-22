int[] occ = new int[4];
for(int x=0; x<1000000; x++){
    int rand = (int)(Math.random() * 4)-2;
    occ[rand+2] ++;
}

System.out.println("Occurrences for -2: " + occ[0]/10000.0 + "%");
System.out.println("Occurrences for -1: " + occ[1]/10000.0 + "%");
System.out.println("Occurrences for 0: " + occ[2]/10000.0 + "%");
System.out.println("Occurrences for 1: " + occ[3]/10000.0 + "%");