Map<String, String> array;

for (String s: items){

    String[] item = s.split("=");
    if(item.length == 2){
        array.put(item[0].trim(), item[1].trim());
    }else{
        System.out.println("Error with: "+ s);
    }
}