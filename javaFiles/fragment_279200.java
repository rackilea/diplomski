String subString = dString.toUpperCase().substring(7);

boolean resultFound = false;

for (Iterator<String> iterator = addressBook2.iterator(); iterator.hasNext();) {
    String s = iterator.next();
    if(s.toUpperCase().contains(subString)) { 
        iterator.remove(); 
        System.out.println("Removal Successful: "+ s); 
        resultFound = true;
    } 
}

if (!resultFound) {
    System.out.println("ERROR: Not found for Removal: "+dString.substring(7));
}
System.out.println("----------------------------");