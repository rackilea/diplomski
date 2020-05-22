double total;
for(int student = 1; student <= 4; student++) {
    System.out.printf("Student %d\n", student);
    double sum = 0, count = 0;

    while(true) {
        System.out.printf("Enter your score: ");
        double input = scanner.nextDouble();
        if(input == -1) break;
        sum += input;
        count++;
    }
    total += sum;

    System.out.printf("Average: %.2f\n", sum / count);
}

System.out.printf("Total: %.2f\n", total);