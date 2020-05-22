List<teetobjects> abcobjects = (List<teetobjects>)feedObjectsGetter.getObjects(file);
//inner most for loop begins
ListIterator<teetobjects> iter = abcobjects.listIterator();
while (iter.hasNext()) {
    teetobjects pecdeedObject = iter.next();
    //checking some condition for each element in the inner most element ....
    if (st.contains(s1)) {
         // if the condition is true then removing the element of the 
         // aaraylist named abcobjects within inner for loop
         iter.remove();
         continue;
    }
}