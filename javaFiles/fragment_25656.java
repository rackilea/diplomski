Scanner sc = new Scanner(System.in);

String hometeam;
String awayteam;
int homescore;
int awayscore;
ArrayList<MatchResult> list = new ArrayList<>();

System.out.println("please enter match results:");
while (sc.hasNextLine()) { // better than the for loop

    String line = sc.nextLine();
    if ("stop".equals(line)) {
        System.out.println(Arrays.toString(list.toArray()));
        return; // exit
    }
    String results[] = line.split(" : "); // parse strings in between

    hometeam = results[0];
    awayteam = results[1];
    homescore = Integer.valueOf(results[2]);
    awayscore = Integer.valueOf(results[3]);

    list.add(new MatchResult(hometeam, awayteam, homescore, awayscore));
}