public void getProps() {
  String[] cur = new String[2];
  Scanner scanner = new Scanner("C:\Path/To/Your/File.txt");
  while(scanner.hasNextLine()) {
    cur = scanner.nextLine().split(":"); // a colon is simpler.
    if(cur[0].equalsIgnoreCase("server_state")) {
      server_state = cur[1];
    }
    if(cur[0].equalsIgnoreCase("health_state")) {
      health_state = cur[1];
    }
    if(cur[0].equalsIgnoreCase("heappercent")) {
      heappercent = Double.parseDouble(cur[1]);
    }
    if(cur[0].equalsIgnoreCase("hoggingthreadcount")) {
      hoggingthreadcount = Integer.parseInt(cur[1]);
    }
    if(cur[0].equalsIgnoreCase("stuckthreadcount")) {
      stuckthreadcount = Integer.parseInt(cur[1]);
    }
  }
  scanner.close();
}