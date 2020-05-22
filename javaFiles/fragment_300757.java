String s = "power:110V;220V;Color:Pink;White;Type:1;2;Condition:New;Used;";
String[] parts = s.split("(?<=;)(?=\\w+:)");
for(String i: parts)
{
    System.out.println(i);
}