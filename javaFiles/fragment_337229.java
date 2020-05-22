isDivisible = false;
for (int i=2; i < value; i++){
    if (value % i == 0){
        isDivisible = true;
        System.out.println(value + " is divisible");
        break;//loop break when divisible
    }
}