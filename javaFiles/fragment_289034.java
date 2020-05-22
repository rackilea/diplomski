public static void main(String[] args)
  {
    String string = "3 42 \n   11   \t  7  dsfss  365          \r   1";
    String[] numbers = string.split("\\D+");
    Arrays.sort(numbers, new Comparator<String>()
    {
      public int compare(String s1, String s2)
      {
        return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
      }
    });
    System.out.println(Arrays.toString(numbers));
  }