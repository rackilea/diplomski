String s = "a:very:big:string";
String[] parts = s.split(":");

for (String part: parts)
{
    System.out.println(part);
}