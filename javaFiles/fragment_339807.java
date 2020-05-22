StringBuilder builder = new StringBuilder();
Iterator<MyClass> iter = myList.iterator();
for (MyClass object = iter.next(); iter.hasNext();) {
    builder.append(object.getPropertyOne());
    if (iter.hasNext()) {
         builder.append(", ");    
    }
}
String result = builder.toString();