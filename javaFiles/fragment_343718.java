String s = "casale-monferrato/incomincia-oggi-roma-l-ultimo-atto-processo-eternit-davanti-corte-cassazione-74506.html";
Pattern regex = Pattern.compile("(?<!\\d)\\d+(?=\\D*$)");
Matcher matcher = regex.matcher(s);
while(matcher.find()){
        System.out.println(matcher.group(0));
 }