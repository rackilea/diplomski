Set<Integer> numbers = new TreeSet<Integer>();

for(int i = 0; i < n; i++) {
    temp1 = reader.nextInt();

    if(numbers.contains(temp1)) {
        // already entered
        break;
    }

    // number is not entered before
    // add it to our array
    finalarray[i] = temp1;

    // also put it in the set for future checks
    numbers.add(temp1);
}