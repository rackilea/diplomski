Integer a = new Integer(6);
List list = new ArrayList();
list.add(a);
list.add("5");
for(int i = 0; i < list.size(); i++)
{
    Integer integer = (Integer)list.get(i); //crashes at "5" which is String at runtime
    System.out.println(integer);
}