String s="mas"; // this is for testing, comes from a List<String>
int hit=0;
Pattern p=Pattern.compile(s,Pattern.CASE_INSENSITIVE);
Matcher m = p.matcher(mybooks.get(i).getBody());
while (m.find()) {
    hit++;
}