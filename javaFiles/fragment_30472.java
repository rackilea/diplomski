Set<String> teamNames = new HashSet<>();

while (scanner.hasNextLine()) {
    String[] parts = scanner.nextLine().split("\\s*:\\s*");
    teamNames.add(parts[0]);
    teamNames.add(parts[2]);
}

for (String teamName : teamNames) {
    System.out.println(teamName);
}