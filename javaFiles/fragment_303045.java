String input = "HD47-4585-GG89-KO89-9089-RT45";

Pattern id = Pattern.compile("(\\w{4}-\\w{4}-\\w{4})");
Matcher matcher = id.matcher(input);

List<String> ids = new ArrayList<>();

while(matcher.find()) {
    ids.add(matcher.group(1));
}

System.out.println(ids); // [HD47-4585-GG89, KO89-9089-RT45]