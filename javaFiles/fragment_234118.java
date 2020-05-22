public static boolean hasDuplicates(String text){
        for(int i = 0; i < text.length() - 1; i++){
            for(int j = i + 1; j < text.length(); j ++){
                if(text.charAt(i) == text.charAt(j)){
                    return true;
                }
            }
        }
        return false;
    }