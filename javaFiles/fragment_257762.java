Formatter formatter = new Formatter();
formatter.format("\\u%04x", i);

// ...

String finalText = formatter.toString();

// Or, if you want to be explicit about it:
//StringBuilder sb = (StringBuilder) formatter.out();
//String finalText = sb.toString();