else if(num%2 == 1 && num>0){
    checker2.kCheck(num, k, kctr);
    odd = 1;
    System.out.println("" +kctr); /*Just to check if the loop is correct and the problem is here. 
                                    It prints the value of kctr on the method kCheck but when it comes to here, it prints 0.*/
}