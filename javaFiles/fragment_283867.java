int sum = 0;
boolean isGood = true;
for(String str : words) {
    try {
        sum += Integer.parseInt(str);
    } catch (NumberFormatException nfe) {
        // If any of the items fails to parse, skip the entire line
        isGood = false;
        continue;
    };
}
if (isGood) {
    // If everything parsed, print the sum
    System.out.println(sum);
}