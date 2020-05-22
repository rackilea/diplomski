Scanner scn = new Scanner(System.in);
int[] scores = new int[] {0,0,0,0,0};
String[] names = new String[] {"Art", "Bob", "Cal", "Dan", "Eli"};
final String PROMPT = "Enter points scored by ";

// a loop to ask for input
// you can treat these loops as saying "for each name in the names array, do this..."
for(int i = 0 ; i < names.length ; i++) {
    // in the first iteration "names[i]" will be "Art", second iteration
    // will be "Bob", and so on
    System.out.print(PROMPT + names[i] + " >>>");
    // set the corresponding score
    scores[i] = scn.nextInt();
}

// another loop to print a bar chart
for(int i = 0 ; i < names.length ; i++) {
    System.out.print(names[i] + " ");

    for (int y = 1; y <= scores[i]; y++) {
        System.out.print(" *");

    }
    System.out.print("\n");
}