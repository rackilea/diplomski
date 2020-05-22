String myString = "RoomA38";
StringBuilder sb = new StringBuilder();
List<Integer> numbers = new ArrayList<Integer>();

for(int i=0;i<myString.length();i++){
    char c = myString.charAt(i);
    if(!Character.isDigit(c)){
        sb.append(c);
    }else{
        numbers.add(Integer.parseInt(c+""));
    }
}

String roomString = sb.toString();
for(Integer i : numbers){
    //use the number i
}