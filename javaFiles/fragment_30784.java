String word = keyboard.next();
StringBuilder sb = new StringBuilder();
for (int counter = word.length() - 1; counter >= 0; counter--) {
    sb.append(word.charAt(counter));
}
System.out.println(word + " backwards is " + sb.toString());