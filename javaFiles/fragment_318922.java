public static String delSpaces(String str){
        int space=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=' '){
                sb.append(str.charAt(i));  // add character
                space=0;
            }else{
                space++;
                if(space==1){       // add 1st space
                    sb.append(" ");
                }
            }
        }
        return new String(sb.toString());
    }