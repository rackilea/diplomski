import java.io.Serializable;
import java.util.ArrayList;

public class Config implements Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<String[]> Data;
    public Config(){
        Data=new ArrayList<String>();

    }

    public void addData(String path){
        Data.add(path);
    }
    public String getData(int index){
        return Data.get(index);
    }

}