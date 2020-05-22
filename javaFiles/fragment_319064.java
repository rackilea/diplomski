class arrayTest {
public static void main(String[] args){
    Integer[] list1 = {12, 43, 56, 72};
    Double[] list2 = {12.5, 45.6, 62.4, 65.8};
    String[] list3 = {"1", "2", "3"};

    printArray(list1);
    printArray(list2);
    printArray(list3);

}

public static void printArray(Object[] list){
         for(Object o : list)
            System.out.println(o);
    }}