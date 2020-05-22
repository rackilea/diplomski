public static void main(String[]args){
    System.out.println("Number");
    int number1= 1;
    float number2= 2.5f;
    Problem1 object1 = new Problem1();
    object1.doThis(number1,number2);
    object1.alsoDo(number1,number2);
    System.out.println(number1+" " + number2);
}