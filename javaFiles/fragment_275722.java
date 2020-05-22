public int averageCustomerAge() {
    if (customerCount == 0) return 0;

    int sum = 0;
    for (int i=0; i < customerCount; i++) {
        sum += customers[i].age;
    }

    int average = sum / customerCount;

    return average;
}