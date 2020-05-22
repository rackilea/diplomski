for (int i = 0; i < t; i++) {
    n = input.nextInt();// no. of timings
    for (int j = 0; j < n; j++) {
        tn = input.nextInt(); // individual time
        // add all values first
        sum += tn;
    }
    // multiply the total of values with 2
    System.out.println(i + ". " + (sum * 2));

    // now set sum=0 for next case
    sum = 0;
}