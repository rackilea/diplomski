public static void main(final String[] args){
    final int[] arr1 = new int[100];
    final int[] arr2 = new int[100];
    int x = 0, y = 0;
    for(int i = 0; i < 100; i++){
        if(i % 10 == 0){
            x++;
        }
        if(i % 12 == 0){
            y++;
        }
        arr1[i] = x;
        arr2[i] = y;
        x++;
        y++;
    }
    System.out.println(atLeastNMatchingElements(70, arr1, arr2));
    System.out.println(atLeastNMatchingElements(95, arr1, arr2));
}