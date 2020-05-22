String text = "This is how how I tried to split a paragraph into a sentence sentence But, there is a problem My paragraph includes dates dates dates dates like Jan 13, 2014 , words includes like U S and numbers"; 
StringBuilder result = new StringBuilder();
HashSet<String> set = new HashSet<String>();
for(String s : text.split(" ")) {
    if (!set.contains(s)) {
        result.append(s);
        result.append(" ");
        set.add(s);
    }
}
System.out.println(result);