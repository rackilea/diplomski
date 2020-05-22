String s = "Brayden Schenn, C GAMES PLAYED: 13, GOALS: 3, ASSISTS: 6, POINTS: 9, PLUS/MINUS: 5, PIM: 7";
Matcher m = Pattern.compile("(([\\w/]+):\\s?(\\d+)),?").matcher(s);
Map<String, Integer> values = new HashMap<String, Integer>();
// find them all
while (m.find()) {
   values.put(m.group(2), Integer.valueOf(m.group(3)));
}
// print the values
System.out.println("Games Played: " + values.get("PLAYED"));
System.out.println("Goals: " + values.get("GOALS"));
System.out.println("Assists: " + values.get("ASSISTS"));
System.out.println("Points: " + values.get("POINTS"));
System.out.println("Plus/Minus: " + values.get("PLUS/MINUS"));
System.out.println("Pim: " + values.get("PIM"));