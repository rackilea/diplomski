public static void IntSym(int[]test) {
    for(int j=0; j<=test.length/2;j++) {
        if(test[j]==test[test.length-j-1]) {
            System.out.println(j+"."+ (test.length-j) +". are equal");
        }else{
            System.out.println(j+"."+ (test.length-j) +". aren't equal");
        }
    }
}