Scanner input = new Scanner(System.in);
System.out.println("This program that reads the integers between 1 and 100 and counts the occurrences of each");
int [] counts = new int [101];
System.out.println("Enter the integers between 1 and 100:");
int next = input.nextInt();
while (next != 0){
    if(next >= 1 && next<= 100)
        counts [next]++;
    next = input.nextInt();
}

// Here's the change
for (int i = 0; i < counts.length; i++) {
    if (counts[i] > 0) {
        System.out.println(i + " occurs " + counts[i] + " times.");
    }
}