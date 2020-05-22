Random rnd = new Random();
    List<Integer> rndNumbers = new ArrayList<>();
    String outputString = "Winner numbers:";

    for(int i = 0; i < 6; i++)
    {
        rndNumbers.add(rnd.nextInt(19) + 1);
        outputString = outputString + " " + rndNumbers.get(i);
    }

    System.out.println();
    System.out.println(outputString);

    for(Integer curNumb : rndNumbers)
    {
        String match = doCompare(curNumb );

        if (match.equals("true"))
        {
            System.out.println("Match on the number: " + curNumb );
        }
    }