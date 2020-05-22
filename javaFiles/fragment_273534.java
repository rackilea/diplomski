long startTime, endTime;

    int amountOfStrings=10000;

    System.err.println("Generating "+amountOfStrings+" String(s)");
    startTime=System.currentTimeMillis();
    String example="";
    for(int i=1; i<amountOfStrings-1; i++) {
        example+=i+",";
    }
    example+=amountOfStrings;
    endTime=System.currentTimeMillis();
    System.err.println("Done in "+(endTime-startTime)+"ms");

    System.err.println("Taking the multisplit-approach");
    startTime=System.currentTimeMillis();
    for(int i=0; i<amountOfStrings-1; i++) {
        System.out.println(example.split(",")[i]);
    }
    endTime=System.currentTimeMillis();
    System.err.println("Done in "+(endTime-startTime)+"ms");

    System.err.println("Taking the onesplit-approach");
    startTime=System.currentTimeMillis();
    String[] data=example.split(",");
    for(int i=0; i<amountOfStrings-1; i++) {
        System.out.println(data[i]);
    }
    endTime=System.currentTimeMillis();
    System.err.println("Done in "+(endTime-startTime)+"ms");