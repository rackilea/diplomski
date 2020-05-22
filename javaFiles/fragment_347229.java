int[] values = {6, 2, 4, 3, 1, 1, 7, 2, 1};
    Integer minimum = null;
    List<Integer> indexes = new ArrayList<Integer>();
    for(int i = 0; i < values.length; i++)
    {
        if(minimum == null || values[i] < minimum)
        {
            minimum = values[i];
            indexes.clear();
            indexes.add(i);
        }
        else if(minimum == values[i])
        {
            indexes.add(i);
        }
    }
    System.out.println("The minimum was: " + minimum);
    System.out.println("It occurred " + indexes.size() + " times in the array");
    System.out.println("Indexes it occured at were: " + Arrays.toString(indexes.toArray(new Integer[]{})));