public static A getObject(String input){
    if(input.indexOf("b") != -1){
        return new B();
    }
    if(input.indexOf("c") != -1){
        return new C();
    }
    return null;
}