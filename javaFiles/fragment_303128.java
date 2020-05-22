public static void main(String[] args){
        String s = "234-236-456-567-678-675-453-564";
        int nth =0;
        int cont =0;
        int i=0;
        for(;i<s.length();i++){
            if(s.charAt(i)=='-')
                nth++;
            if(nth == 3 || i==s.length()-1){
                if(i==s.length()-1) //with this if you preveent to cut the last number
                System.out.println(s.substring(cont,i+1));
                else
                    System.out.println(s.substring(cont,i));
                nth=0;
                cont =i+1;


            }
        }
    }