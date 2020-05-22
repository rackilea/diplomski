Scanner in = new Scanner(System.in);
      int n = in.nextInt();
      int fact = 1;
      String s = n + "! = 1";
      for (int i = 2; i <= n; i++) {
         fact *= i;
         s += "*" + i;
      }
      s += " = ";
      System.out.println(s + fact);