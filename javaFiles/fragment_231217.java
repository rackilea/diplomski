ArrayList<String> myArr = new ArrayList<String>();
ArrayList<String> myArrDub = new ArrayList<String>();
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
String str = bf.readLine();

for (int i=0; i<str.length(); i++) {
    String tempStr = new String();
    tempStr += str.charAt(i);
    myArr.add(tempStr);
}

System.out.println(myArr);

for(int i=0;i<myArr.size();i++){
    if(myArr.get(i).equals("1"))
    myArrDub.add("10");
else
    myArrDub.add("01");
}