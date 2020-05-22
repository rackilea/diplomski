class Test {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        list = reverse(list);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
   }

   public static int[] reverse(int[] list) {
       int[] newList = new int[list.length];

       for (int i = 0; i < list.length; i++) {
           newList[i] = list[list.length - 1 - i];
       }

       return newList;
   }
}