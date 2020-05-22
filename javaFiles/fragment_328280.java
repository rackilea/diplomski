while ((n = in.nextInt()) != 0) {
    total += n;
    count++;
    if (n % 2 == 0) {
        evenNumber++;
    } else {
        oddNumber++;
    }
    largest = Math.max(n, largest);
    smallest = Math.min(n, smallest);
}