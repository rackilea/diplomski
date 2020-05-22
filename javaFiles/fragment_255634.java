Scanner in = new Scanner(System.in);
int[] weights = new int[10];
for (int i = 0 ; i < 10 ; i++) {
    System.out.print("Enter a weight between 20 and 100: ");
    weights[i] = in.nextInt();
}
in.close();

int min = weights[0];
int max = weights[0];
double avg = 0;

for (int weight : weights) {
    if (weight < min)
        min = weight;
    if (weight > max)
        max = weight;
    avg += weight;
}

avg /= weights.length;

System.out.println("Min: " + min);
System.out.println("Max: " + max);
System.out.println("Average: " + avg);