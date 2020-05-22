String start = "transmit=[D-1]0.0 [D-2]0.0 [D-3]0.039236154";
start = start.split("=")[1];
String[] split = start.split(" ");
HashMap<String, Double> transmitValues = new HashMap<String, Double>();
for(String str : split){
    String[] s = str.split("\\]");
    transmitValues.put(s[0] + "]", Double.parseDouble(s[1]));
}