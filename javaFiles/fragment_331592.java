public static void main(String[] args){
    Random r = new Random();

    int[] values = new int[10];

    for(int i=0;i<values.length;i++){
        values[i] = r.nextInt(2);
    }

    System.out.println(Arrays.toString(values));
}