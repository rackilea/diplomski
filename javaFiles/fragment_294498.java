String s = "afsgdhgd gfgshfdgadh a sed afdsgdhgdsfgdfagdfhh";
Pattern pattern = Pattern.compile("a\\s+sed");
Matcher matcher = pattern.matcher(s);
while (matcher.find()){
    System.out.println(matcher.group(0)); 
}