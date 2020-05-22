public class NewClass {

    public static int evaluate(String str){
        if("".equals(str)){
            return 0;
        }
        else if(str.length() == 1){
            return Integer.valueOf(str);
        }
        else{
            String _a = String.valueOf(str.charAt(0));
            String _b = String.valueOf(str.charAt(1));
            if("+".equals(_b) || "-".equals(_b) ){
                if("+".equals(_b)){
                    return Integer.valueOf(_a) + evaluate(str.substring(2));
                }
                else{// "-"
                    return Integer.valueOf(_a) - evaluate(str.substring(2));
                }
            }
            else{// "*" or "/"
                boolean isMulti = ("*".equals(_b));
                String  _c = String.valueOf(str.charAt(2));                
                Integer tmp = 0;
                if(isMulti){
                    tmp = Integer.valueOf(_a) * Integer.valueOf(_c);
                }
                else{
                    tmp = Integer.valueOf(_a) / Integer.valueOf(_c);
                }
                String new_str = String.valueOf(tmp) + str.substring(3);                
                return evaluate(new_str);
            }
        }
    }

    public static void main(String[] args){        
        String e = "4+1*3";
        int t = evaluate(e);
        System.out.println(e + " = "+t);
    }

}