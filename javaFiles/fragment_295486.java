String s = "ddjdjdj+kfkfkf";

if(s.contains("+"))
{
    String parts[] = s.split("\\+");
    System.out.print(parts[0]);
}