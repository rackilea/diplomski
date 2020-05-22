String Text = "But I know. For example, the word \"can\'t\" should";

String[] Res = Text.split("[\\p{Punct}\\s]+");
System.out.println(Res.length);
for (String s:Res){
    System.out.println(s);
}