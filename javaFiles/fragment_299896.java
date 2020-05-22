String route = "ABCDE";
if( route.length() > 2){
    int i = 0;
    do {
        String res = route.substring(i,i+2);
        System.out.println(res);
        i++;
    } while (i + 1 < route.length());
}
else{
    System.out.println(route);
}