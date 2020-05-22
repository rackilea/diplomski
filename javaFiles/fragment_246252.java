String str = "[project1_john_document1, project1_john_document2, project2_jose_document1, project2_jose_document2, project3_juan_document1]";
Pattern p = Pattern.compile("project\\d+");
Matcher m = p.matcher(str);
Map<String, Integer> map = new HashMap<>();
String project;
while (m.find()) {
    project = m.group();
    if (map.containsKey(project )) {
        map.put(project , map.get(project ) + 1);
    } else {
        map.put(project , 1);
    }
}
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + "\t" + entry.getValue());
}