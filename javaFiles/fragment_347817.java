int random = ThreadLocalRandom.current().nextInt(0, 1000);
    int count = 0;
    int answer;
    do {
        answer = ThreadLocalRandom.current().nextInt(0, 1000);
        count++;
    } while (random != answer);

    System.out.println("Answer: " + answer + " " + "Count: " + count);
}