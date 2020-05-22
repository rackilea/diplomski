List<String> x1 = new ArrayList<String>();
Object c3 = x1;
x1.add("asdsad");
Integer y2 = new Integer(5);
if (c3 instanceof List<?>){
     ((List<Object>)c3).add((Object)y2);
}

for (Object i : (List<Object>)c3){
    if (i instanceof String){
        System.out.println("String: " + (String)i);
    }
    if (i instanceof Integer){
        System.out.println("Integer: "+ (Integer)i);
    }
}