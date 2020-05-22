String result = "";
for(String binNum: M.trim().split(" ")){
     int charCode = Integer.parseInt(binNum, 2);
     result+=Character.toString((char)charCode);
}
System.out.println(result); // Here is the complete string...