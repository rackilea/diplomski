String personArray ="{{Melroy,25,India},{Jack,26,USA}}";

    Pattern pattern = Pattern.compile("\\{([A-Za-z]+),([0-9]+),([A-Za-z]+)\\}"); 

    Matcher matcher = pattern.matcher(personArray);

    List<Object[]> list = new ArrayList<>();
     //using list as we don't know number of final elements, 

    int start = 0;
    while(
        matcher.find(start)){
        list.add(new Object[]{matcher.group(1),matcher.group(2),matcher.group(3)});
        start  = matcher.end();

    }

    //convert to array, to have required format
    Object[][] array = list.toArray(new Object[0][]);

    //test result
    for (Object[] arr : array)
        System.out.println(Arrays.toString(arr));