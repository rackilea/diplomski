Set<String> uniquePairs = new HashSet<String>();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();    // Ignore the next line char.

    for(int i=0; i<t ;++i) {
      if(sc.hasNextLine()) {
        String element = sc.nextLine();
        uniquePairs.add(element);
        System.out.println(uniquePairs.size());
      }