class Foo {
public int a; //For each obj
public static int b=3; //Global var of the class, acessable from anywhere
public Foo(int a) {
this.a=a;
}
}

System.out.println(new Foo(0).a); //-> 0