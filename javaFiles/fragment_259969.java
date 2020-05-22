public static void tentimes(Function f){
    for(int i = 0; i < 10; i++)
       f();
 }
 ...
 public static void main{
    ...
    tentimes(System.out.println("hello"));
    ...
 }