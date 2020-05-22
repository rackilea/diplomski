if(morse.indexOf(".-")!=-1){
    System.out.print("A");
    morse=morse.substring(morse.indexOf(".-")+2); // where 2 morse characters
    continue; //your hypothetical loop
 }
 if(morse.indexOf("-...")!=-1){
    System.out.print("B");
    morse=morse.substring(morse.indexOf("-...")+4); // where 4 morse characters
    continue; //your hypothetical loop
 }
 ...