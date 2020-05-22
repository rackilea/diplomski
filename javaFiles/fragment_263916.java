long startTime, endTime, duration;
        startTime = System.nanoTime();
        System.out.println(palindromeUsingStringBuilderReverse(str));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration for using string builder : " + duration);

        startTime = System.nanoTime();
        System.out.println(palindromeUsingForLoop(str));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration for using for loop : " + duration);

        startTime = System.nanoTime();
        System.out.println(palindromeUsingWhile(str));
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Duration for using while loop : " + duration);