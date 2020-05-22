private int greatestCommmonNumetaror(){
    int count = 1;
    int first;
    int mod;
    System.out.println("Outside while: count is "+count+" and this.numerator is "+this.numerator);
    while(count != this.numerator){// need help with this
        System.out.println("In while: Count is "+count);
        mod = this.numerator%count;
        System.out.println("In while: mod is "+mod);
        if(mod != 0){
            first = count;
            System.out.println("In while and if: first is "+first+" and count is "+count);
            if(first < count){
                first = count;
                System.out.println("In while and if and if: first is "+first+" and count is "+count);
            }
        }
        count++;
    }
    return 1;
}

public String printFraction(){
    int numerator = greatestCommmonNumetaror();
    return "";
}