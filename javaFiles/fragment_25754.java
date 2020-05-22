public static void SelectionSort(int[] ray){

    for(int j = 0; j < ray.length; j++){

    int low = j;
    for(int i = j; i < ray.length;i++){
        if(ray[i] < ray[low])
            low = i;
    }
    System.out.println(ray[low]);
    int temp = ray[low];
    ray[low] = ray[j];
    ray[j] = temp;
}