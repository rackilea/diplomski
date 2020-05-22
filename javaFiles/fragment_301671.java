// Using a list.
final int teamCount = 10;
final List<String> teams = new ArrayList<>();
for (int teamIndex = 0; teamIndex < teamCount; teamIndex++)
    teams.add("team" + (teamIndex + 1));
Collections.shuffle(teams);
System.out.println("teams: " + teams);

// Using an array.
final int teamCount = 10;
final String[] teams = new String[teamCount];
for (int teamIndex = 0; teamIndex < teamCount; teamIndex++)
    teams[teamIndex] = "team" + (teamIndex + 1);
Collections.shuffle(Arrays.asList(teams));
System.out.println("teams: " + Arrays.toString(teams));