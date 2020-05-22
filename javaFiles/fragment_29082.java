public static <T extends Comparable<T>> int compareTo(T o1,T o2){

    if(o1==o2){
        //Equals
        return 0;
    }else if(o1!=null && o2!=null){
        //Comparation 
        return o1.compareTo(o2);
    }else{
        //Not equals
        return (o1==null?-1:1);
    }               

}