public class arrayBase{
    public base[] ab = new base[2];    
    public arrayBase() {  
       ab[0] = new base();
       ab[0].a = 1;
       ab[0].b = "test1";

       ab[1] = new base();
       ab[1].a = 2;
       ab[1].b = "test2";       
    }
  }