public class A{

      public B b;
      public C c = new C();
      public D d = new D();

      public A(){
         b = new B(this);
         b.changeData();
      }
    }

    public class B{
      private A a;

      public B(A a){
         this.a = a;
      }
      public void changeData(){
         a.d.changeSomethingInD();
      }
    }