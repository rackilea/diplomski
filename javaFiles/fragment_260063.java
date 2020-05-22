Set set = *method argument*;
Iterator iter = set.iterator();
while (iter.hasNext()) {
   Object object = iter.next();
   System.out.println(object.getClass());
}