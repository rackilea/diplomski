boolean firstLine = true;
 Scanner input = new Scanner(new FileInputStream(<file>));
 while (input.hasNextLine()) {
    String line = input.nextLine();
    if (firstLine) {
      setTeamName (line);
      firstLine = false;
      continue;
    }

    // convert line to Double
    // perform Math
}