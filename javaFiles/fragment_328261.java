String string = rsBundle.getString("SPAN_NUMBER");
if(string != null) {
    string = string.replaceAll("\\D","");
    if(string.length()==0) string="0";
    int i = Integer.parseInt(string);
}