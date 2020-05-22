public static void usingRecursion(String str){
        System.out.println(replaceD_2(str, ""));
    }

    private static String replaceD_2(String str, String str2){
        String str1 = "";

        if(str.length() == 0){
            return str2;
        }
        if(str.charAt(0) >= '0' && str.charAt(0) <= '9'){
            str2 = str2 + str.charAt(0);
        }
        else {
            str1 = str1 + str.charAt(0);
        }
        return str1 + replaceD_2(str.substring(1), str2);
    }