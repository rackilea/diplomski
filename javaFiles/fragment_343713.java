public static String reverse(String s,String h){

    if(s.length() == 0){

        return h;

    } else {


        h+=s.charAt(s.length()-1);
        System.out.println(h);//FOR TEST
        s=s.substring(0,s.length()-1);
        return reverse(s,h); //NOTICE THE CHANGE HERE,
    }

}