char [] regKey = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
char [] newKey = new char [26];
String[] array = new String(regKey).split("", 0);
ArrayList<String> yourNewArrayList = new ArrayList<String>();
Collections.addAll(yourNewArrayList, array);
Collections.shuffle(yourNewArrayList);
for (int i = 0; i < newKey.length; i++) {
    newKey[i] = yourNewArrayList.remove(0).toCharArray()[0];
}