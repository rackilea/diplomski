public static void main(String[] args)
  {

      String input = "Kenny and I are eating in the Restaurant Yummy";
      String expectedResult = "Kenny, I, Restaurant, Yummy";
      String arr [] = input.split (" ");

      StringBuilder out = new StringBuilder();
      for (int i = 0; i < arr.length; i++) {
          if (Character.isUpperCase(arr[i].charAt(0))) {
              out.append(arr[i]).append(", ");
          }
      }

      if (out.length() > 1) {
          out.setLength(out.length() -2);
      }

      System.out.println (out);
      assert (expectedResult.equals(out.toString()));

  }