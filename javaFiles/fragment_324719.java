ArrayList<String> list = new ArrayList<String>();
Random rand = new Random();
String alphabet = "abcdefghijklmnopqrstuvwxyz";
for (int i = 0; i < 10; i++){
    list.add(String.valueOf(alphabet.charAt(rand.nextInt(alphabet.length()))));
}