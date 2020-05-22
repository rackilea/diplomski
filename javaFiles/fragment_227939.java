String line = System.getProperty("Arguments");
if(line != null) {
  String str[] = line.split(",");
    for(int i=1;i<str.length;i++){
        String arr[] = str[i].split("=");
        System.out.println("Key = " + arr[0]);
        System.out.println("Value = " +  arr[1]);
    }
}