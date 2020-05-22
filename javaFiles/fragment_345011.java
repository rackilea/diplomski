List<String> MyStrings =new ArrayList<String>();
List<String> MySortStrings =new ArrayList<String>();
MyStrings.add("Dog");
MyStrings.add("Cat");
MyStrings.add("Can");
MyStrings.add("Ant");
MyStrings.add("Str");
String sweet="c";
for(int i=0;i<MyStrings.size();i++)
{
    if(MyStrings.get(i).startsWith(sweet.toUpperCase()))
    {
        MySortStrings.add(MyStrings.get(i));
    }
}

System.out.println(MySortStrings.size());