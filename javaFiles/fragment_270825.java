Set<String> uniquePairs = new HashSet<String>();
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.useDelimiter(System.getProperty("line.separator"));
    for(int i=0; i<t ;++i) {
      if(sc.hasNextLine()) {
        String element = sc.nextLine();
        uniquePairs.add(element);
        System.out.println(uniquePairs.size());
      }