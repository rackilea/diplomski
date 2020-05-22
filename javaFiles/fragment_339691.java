String str = "01234";
Integer sum = IntStream.range(0, str.length())
                       .filter(i -> i % 2 == 0)
                       .map(str::charAt)
                       .sum();
System.out.println(sum);