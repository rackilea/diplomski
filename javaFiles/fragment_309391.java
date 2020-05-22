package packageone.com;
public class HavingLocalClass {
    public HavingLocalClass() {
        // TODO Auto-generated constructor stub
    }
     void TestMethod(int a){
        class LocalClass{
            int localVar;
            public void display(){
            System.out.println(localVar);
            }

            public LocalClass(int localVar) {
                this.localVar=localVar;
                // TODO Auto-generated constructor stub
            }



            }

            LocalClass lc=new LocalClass(a);
            System.out.println(lc.localVar);
            /* If i directly try to print localVar here it will
                give me error */
            //System.out.println(localVar);//cannot be resolved into variable


    }
}