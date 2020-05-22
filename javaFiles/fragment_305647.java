int index = 0;
while(playerNamesScan.hasNextLine() && index < theList.length) {
    names = playerNamesScan.nextLine(); 
    theList[index++] = names;
    System.out.println(names);   //just to make sure it is scanning in all the names
    System.out.println(theList[0]);  //this gives me null because not in array
}