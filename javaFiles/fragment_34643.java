public static void main(String[] args) {

    int[] test1 = { 3, 2, 5, 11, 11, 11, 233, 22, 3, 3, 3, 5, 5, 5 };   
    int[] test2 = { 3, 3, 3, 8, 3, 11, 233, 22, 3, 3, 3, 5, 5, 5 };
    int[] test3 = { 3, 2, 5, 8, 3, 11, 233, 22, 3, 3, 4, 3, 3, 3 };
    int[] test4 = { 3, 2, 5, 8, 3, 11, 233, 22, 3, 3, 5, 5, 5 }; 

    Test test = new Test();
    System.out.println(test.haveThree(test1));
    System.out.println(test.haveThree(test2));
    System.out.println(test.haveThree(test3));
    System.out.println(test.haveThree(test4));

}