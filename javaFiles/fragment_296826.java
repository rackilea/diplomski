public static void main(String[] args)
  {
    Scanner scnr = new Scanner(System.in);
    System.out.print("How many schools do you have in your district: ");
    int nos = scnr.nextInt();
    List<Map.Entry<Integer, Double>> schools = new ArrayList<>();
    System.out.println();

    double ax = 0;

    for (int i = 1; i < nos + 1; ++i)
    {
      System.out.println("Enter data for school " + i);
      System.out.print("   How many students are enrolled in school : ");
      int num = scnr.nextInt();

      System.out.print("   Enter the attendance for day 1: ");
      int d1 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 2: ");
      int d2 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 3: ");
      int d3 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 4: ");
      int d4 = scnr.nextInt();

      System.out.print("   Enter the attendance for day 5: ");
      int d5 = scnr.nextInt();

      double avg = ((d1 + d2 + d3 + d4 + d5) / 5) * 100;
      double att = avg / num;

      schools.add(Map.entry(i, att));

      ax = att + ax;

      System.out.println();

      System.out.println("Attendance " + att + "% for school " + i);
      System.out.println();
    }
    System.out.print(ax);
    schools.sort((a,b)->(int)Math.round(b.getValue()-a.getValue()));
    System.out.println("The school with best attendance is school " + schools.get(0).getKey() + " with " + schools.get(0).getValue() + "% attendance!");
  }