ListIterator<String> it = firstNames.listIterator(); 
while(it.hasNext()){
   it.set(it.next().split(" ")[0])
}

it = lastNames.listIterator(); 
while(it.hasNext()){
   it.set(it.next().split(" ")[1])
}