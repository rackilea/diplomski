String str = "abcdefkeybncv...";
String key = "key";
int index = str.indexOf(key);
ArrayList<String> sub = new ArrayList<String>();
for (int i = 0; i < str.length(); i++) {
    for (int j = 0; j <= str.length() - i; j++) {
        String s = str.substring(i, i+j);
        if(s.indexOf(key) >= 0){
            sub.add(s);
        }
    }
}
System.out.println(sub);