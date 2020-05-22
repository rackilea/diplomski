String[][] matrix = { { "1", "2", "3" } };
List<Integer> list = new ArrayList();
    String[] y= { "TEST" ,"BUG"};
    int a = 0;
    int value;
    for (int i = 0; i < y; i++)
    {

      for (int j = 1; j < 4; j++)
      {

        value = Integer.parseInt(matrix[i][j - 1]);
        list.add(value);
        System.out.println(value ); //this is OK it print me 3 values
      }
    }
System.out.println(value );