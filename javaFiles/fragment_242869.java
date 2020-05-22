String s = "a [Title: title] [Content: content]";
String parts[] = s.split("\\s(?![^\\[\\]]*\\])");  # Splits the input according to spaces which are not present inside the square brackets
ArrayList<String> l = new ArrayList<String>();
for (String i: parts)                              # iterate over the array list elements.
{
    l.add(i.replaceAll("[\\[\\]]", ""));           # replace all [, ] chars from the list elements and append it to the declared list l
}
System.out.println(l);