private static final String[] arr={"foo","duck","man".....,"xyz"}
private static final Pattern replacer;
static {//done once only
    StringBuilder strb= new StringBuilder();
    for(String str:arr){
        strb.append("\\b").append(Pattern.quote(str)).append("\\b|");
        //using word break to avoid ***umptions;
    }
    strb.setLength(strb.length()-1);
    replacer = Pattern.compile(strb.toString());
}

public String replaceFoo(String in){
    return replacer.matcher(in).replaceAll("***");
}