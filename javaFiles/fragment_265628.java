public static void result(char[] a,char[] b) {
//APPENDING BOTH THE STRING CHARACTER BY CHARACTER
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();    
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while( i < arrayA.length && i < arrayB.length){
        sb.append(arrayA[i]).append(arrayB[i]);
        ++i;
        }
        for(int j = i; j < arrayA.length; ++j){
            sb.append(arrayA[j]);
        }
        for(int j = i; j < arrayB.length; ++j){
            sb.append(arrayB[j]);
        }
        System.out.println(sb.toString()); 
  }           
}