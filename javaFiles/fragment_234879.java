private static ArrayList<String> getListOfValues(){
    ArrayList<String> listInt = new ArrayList<String>(10000);
    for(int i = 0; i < 10000; i++){
        if(i < 10) listInt.add("000"+i);
        else if(i < 100) listInt.add("00"+i);
        else if(i < 1000) listInt.add("0"+i);
        else listInt.add(Integer.toString(i));
    }
    return listInt;
}