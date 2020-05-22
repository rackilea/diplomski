public static  void swap(String s){
        int index=0;
        char[] chars=s.toCharArray();
        for(char c:chars){

            if('.'==c)
            chars[index]=',';
            else if(','==c){
                chars[index]='.';
            }
            index++;

        }
        System.out.println(String.valueOf(chars));
    }