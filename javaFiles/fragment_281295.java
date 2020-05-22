public static void main(String[] args) {
        String s = "2a[2b[c]]]";         
        Stack s1 = new Stack();
        for(int i=0;i<s.length();i++) {
            s1.push(s.charAt(i));
        }
        String str="";
        String sss="";
        for(int j=0;j<s.length();j++) {
            char a = (char)s1.pop();
            System.out.println("a:"+a);
            // if(a == '')
            if((int)a >=49 && (int)a<=58){
                for(int i=0;i<(int)a-48;i++){
                    sss=str;
                    sss+=str;
                    System.out.println("sss:"+sss);
                }
                str=sss;
            }
            //character
            else if((int)a >=97 && (int)a <= 122){
                str = a + str;
                System.out.println("str:"+str);
            }
        }
        System.out.println(sss);
    }