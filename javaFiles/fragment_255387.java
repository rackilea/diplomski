String s = "I read books";
String[] arr = s.split("\\s");
List<String> list = new ArrayList<>();
for(int i=0; i<arr.length; i++) {
    int t = i;
    String temp = "";
    while(t<arr.length) {
        list.add(temp + arr[t]);
        temp += arr[t] + " ";
        t++;
    }
}
System.out.println(list);