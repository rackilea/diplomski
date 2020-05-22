List<Object> objectList = new ArrayList<Object>();
objectList.addAll(Arrays.asList(0,"sfsd",2,3.14,new Regexp("Test")));
for(Object object:objectList)
{
    System.out.println(object);
}