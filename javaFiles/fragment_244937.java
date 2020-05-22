String query = "INSERT INTO table_name VALUES";

Pattern pattern = Pattern.compile("(.*?\\s+.*?\\s+)(.*?)(\\s.*)");
Matcher matcher = pattern.matcher(query);
while (matcher.find()) {
    query = matcher.group(1) + 
            String.format("[%s]", matcher.group(2).toUpperCase()) + 
            matcher.group(3);
}

System.out.println(query);