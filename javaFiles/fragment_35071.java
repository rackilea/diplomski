public class X{
    public X(Y y){
        y.setY(0);
    }
}

public class Y{
   public int val=0;
   public void setY(int p_val){
       val=p_val;
   }
}

public class Main{
    public void modifyY(){
         new X(new y());
    }
}