class B{
    A objectA[]=new A[10] ;
    {
        for (int i = 0; i < 10; i++)
            objectA[i] = new A();
    }
}

class C{
B ObjectB = new B();
public static void main(String[] args){
ObjectB.ObjectA[0].a=1;
}
}