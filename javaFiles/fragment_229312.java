public static void main(String[] args){
    String toBeReplaced0 = "alpha";
    String toBeReplaced1 = "beta";
    String toBeReplaced2 = "gama";
    String test = "{\"userName\": \"<userName>\",\"firstName\": \"<firstName>\",\"lastName\": \"<lastName>\"}";
    System.out.println(findAndReplace(test,toBeReplaced0,toBeReplaced1,toBeReplaced2));        
}
public static String findAndReplace(String original, String... replacments){
    Pattern p = Pattern.compile("<[^<]*>");
    Matcher m1 = p.matcher(original);
    // count the matches
    int count = 0;
    while (m1.find()){
        count++; 
    }
    // if matches count equals replacement params length replace in the given order
    if(count == replacments.length){
        Matcher m = p.matcher(original);
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (m.find()) {
            m.appendReplacement(sb, replacments[i]);
            i++;
        }
        m.appendTail(sb);            
        return sb.toString();
    }
    //else return original
    return original;
}