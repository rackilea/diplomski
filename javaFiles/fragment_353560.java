while(read.hasNextLine() && counter < 10)
{
    numbers.add(read.nextDouble());
    counter++;
}
for (int n = 0; n < 50; n++) {
    Collections.shuffle(numbers);
    for (int i = 0; i < numbers.size(); i++) {
        System.out.println(numbers.get(i));
    }
    System.out.println();
}