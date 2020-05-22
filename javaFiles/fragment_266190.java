public interface JSONable{
     String toString();
     //other common methods
}

public Pojo1 implements JSONable{
     public String toString(){
       super.toString();
    }
}