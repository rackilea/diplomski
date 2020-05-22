public interface Myinterface {
public void save(PolicyData p);
}

public class Product implements Myinterface{
public void save(PolicyData p){
    //logic here
}


public class Controller {


    private static HashMap<String,Myinterface> map=new HashMap<String,Myinterface>();

    public Controller(){
        map.put("Product", new Product());
        map.put("Limit", new Limit());
        map.put("Coverage", new Coverage());
    }

    public void save(PolicyData p,String item){
    Myinterface m=map.get(item);
    m.save(p);
    }
}
    }