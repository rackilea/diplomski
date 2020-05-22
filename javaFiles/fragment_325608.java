List<String> res = Files.readAllLines(Paths.get("TimeTable.csv"));
String p = "(?i)^\"([\\p{L}_]+) (\\p{L}+) ([\\p{L}\\p{N}-_]+) (?:.+)?\",\"(\\d+)\\.(\\d+)\\.(\\d+)\",\"(\\d+):(\\d+):(\\d+)\"(?:.*?)$";
String rep = "$6-$5-$4 ==> $7:$8 $1 $2 $3";
for (String str : res){
    System.out.println(str.replaceAll(p, rep));
}