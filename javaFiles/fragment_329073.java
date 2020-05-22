//get rid of int i;
if(array.length > 0) {
    System.out.println("{");
    for(int i = 0; i < array.length - 1; i++) {
        System.out.print(array[i] + ", ");
    }
    System.out.println("}" + array[i]);
} else {
    System.out.println("{}");
}