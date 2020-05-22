ArrayList<String> listCopy = yourList.clone();
Iterator<String> it = listCopy.iterator();
while(it.hasNext()){
    String element = it.next();
    if(element.contains(Character.toString(yourChar)){
        yourList.remove(element);
    }
}