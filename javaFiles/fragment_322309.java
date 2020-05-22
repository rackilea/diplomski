String input= "This is a string with differently sized words. This is another sentence." ;
String[] splitInput= input.split("[ .]") ;
TreeMap<String,String> theMap= new TreeMap<String,String>() ;
int index= 0 ;
for(String word: splitInput ) {
    if( word.length() > 0 ) {
        String key= String.format("%03d%05d",(999-word.length()),index) ;
        theMap.put(key,word);
        index++;
    }
}
System.out.println(theMap.values());