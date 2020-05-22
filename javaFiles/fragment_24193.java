String list = "hey there how are you";
String[] strarray = list.split("\\s+");
for (String str: strarray)
{
    System.out.print(str);
}