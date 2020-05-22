static void capitalizer(String a,int b){
    if(b==-1){
        System.out.println(a); //CHANGE: printing in the stop clause
    }else{
        char[] achars = a.toCharArray();
        achars[b] -= 32;
        String caplet = new String(achars);
        //CHANGE: not printing every iteration
        capitalizer(caplet,b-1);
        capitalizer(a,b-1);
    }
}