List<String> delimiters = new ArrayList<>();
delimiters.add("+");
delimiters.add("-");
delimiters.add("/");
delimiters.add("*");
delimiters.add("%");

List<String> list = new ArrayList<>();

list.add("a");
list.add("b");
list.add("c");
list.add("d");
list.add("+");
list.add("-");
list.add("/");
list.add("*");
list.add("%");

for (String s : list)
{
    if (delimiters.contains(s))
    {
        System.out.println("This is a delimiter. " + s);
    }
}