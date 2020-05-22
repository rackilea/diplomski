Iterator<YourClass> it = yourDeque.iterator();
YourClass foundInstance = null;
while(it.hasNext()) {
    YourClass obj = it.next();
    if(obj.equal(theInstanceYouAreSearchingFor)) {
        foundInstance = obj;
        break;
    }
}
if(foundInstance != null) {
   yourDeque.remove(foundInstance); // if you wish to remove it as well
}