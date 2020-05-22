public void foo(String str){
    System.out.println(str);
}

public void foo(String... str){
    System.out.println("varargs");
    for(String s: str){
        System.out.println(s);
    }
}