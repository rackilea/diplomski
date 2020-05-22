String data = "\"file one.txt\" filetwo.txt some other \"things here\"";

List<String> tokens = new ArrayList<String>();
StringBuilder sb = new StringBuilder();

boolean insideQuote = false;

for (char c : data.toCharArray()) {

    if (c == '"')
        insideQuote = !insideQuote;

    if (c == ' ' && !insideQuote) {//when space is not inside quote split..
        tokens.add(sb.toString()); //token is ready, lets add it to list
        sb.delete(0, sb.length()); //and reset StringBuilder`s content
    } else 
        sb.append(c);//else add character to token
}
//lets not forget about last token that doesn't have space after it
tokens.add(sb.toString());

String[] array=tokens.toArray(new String[0]);
System.out.println(Arrays.toString(array));