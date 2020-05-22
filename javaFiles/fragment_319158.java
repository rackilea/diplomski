public static void main(String[] args){

            String sentence = "Hello my name is JAva im a jaVa Man with a jAvA java Ice cream";
            String find="java";
            String replace="JAVA";
            String result="";
            int n;
            //for you to ignore(converts the sentence to lowercase) either lower or upper case in your sentence then do the nxt process
            sentence = sentence.toLowerCase();
            System.out.println(sentence);

            do{


                n=sentence.indexOf(find);
                if(n!=-1){
                    result =sentence.substring(0,n);
                    result=result +replace;
                    result = result + sentence.substring(n+find.length());
                    sentence=result;            
                }
            }while(n!=-1);

            System.out.println(sentence);
    }