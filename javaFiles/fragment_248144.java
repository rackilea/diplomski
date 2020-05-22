private Scanner inp = new Scanner( System.in);
private ArrayList<String> foodList = new ArrayList<String>();
private int[] ingredientCount;

public A1() {
    foodList.add("baking powder");
    foodList.add("baking soda");
    // ...
    foodList.add("oil");
    foodList.add("fish");

    ingredientCount = new int[foodList.size()];
}

private void readFile() {
  while (inp.hasNext()) {
      String nextLine = inp.next().toLowerCase();

      for(int i=0; i<foodList.size(); i++)
      {
        if (nextLine.contains(foodList.get(i))) { 
          ingredientCount[i] += 1;
        }
      }
  }

  for(int i=0; i<foodList.size(); i++)
  {
    System.out.printf("%s occured %d time(s)\n", foodList.get(i), ingredientCount[i]);
  }
}