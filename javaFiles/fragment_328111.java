StringBuilder builder = new StringBuilder();
String[] splits = VIA.split("\d+\.+");
for(String split : splits){
   builder.append(split).append("\n");
}

String output = builder.toString().trim();