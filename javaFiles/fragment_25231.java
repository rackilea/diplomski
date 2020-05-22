public static List<String> getWords(String str){
    String[] strArray=str.split(" "); 
    List<String> listStr = new ArrayList<String>();
    for(String strInArray : strArray){
          listStr.add(strInArray);
    }

    return listStr;
}