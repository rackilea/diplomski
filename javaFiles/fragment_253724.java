public class IteratorTest{

    static int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int index = 0;

    public static void main(String[] args){
        for (int i = 0; i < 10; i++){
            System.out.println(getNext());
        }
    }

    public static int getNext(){
        return numbers[index++];
    }

}