public static void read(String name) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(SubscriptionService.class.getResourceAsStream(name)));
    ArrayList<String> IDs = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    String line;
    String[] tokens;
    while ((line = reader.readLine()) != null) {
      tokens = line.split(",");
      if (tokens.length != 2) { // Skip any "weird" (e.g., empty) line
        continue;
      }
      IDs.add(tokens[0].trim());
      names.add(tokens[1].trim());
    }
    System.out.println("Member_ID\tUsername");
    for (int i = 0; i < IDs.size(); i++) { // IDs and names have the same size
      System.out.println(IDs.get(i) + "\t" + names.get(i));
    }
  }