String example = "something";
    String firstLetter  = "";

    long l=System.nanoTime();
    firstLetter = String.valueOf(example.charAt(0));
    System.out.println("String.valueOf: "+ (System.nanoTime()-l));

    l=System.nanoTime();
    firstLetter = Character.toString(example.charAt(0));
    System.out.println("Character.toString: "+ (System.nanoTime()-l));

    l=System.nanoTime();
    firstLetter = example.substring(0, 1);
    System.out.println("substring: "+ (System.nanoTime()-l));