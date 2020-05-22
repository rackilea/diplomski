StringBuilder sb = new StringBuilder();    
while((l = in.readLine()) != null) {
    sb.append(l);
}
String[] sentences = sb.toString().split(".");
for (int i = 0 ; i < 50 ; i++){
    System.out.println(sentences[i]);
}