public static void main(String[] args) {
     int[] ar={2,4,2};
     int[] p=new int[ar.length];
     int count=0;
     for (int i=0;i<ar.length ;i++ ) {
        while (ar[i] % 2 == 0 && ar[i] > 0) { // keep dividing ar[i] by 2 as long as 
                                              // it is divisible by 2
            ar[i]=ar[i]/2;
            count++;
        }
     }
     for (int x:ar) {
        System.out.println(x);
     }
     System.out.println("Count:"+count);
}