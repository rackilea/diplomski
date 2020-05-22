package so;

public interface Database {
    void connect();
}

package so;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseImpl implements Database {

    @Override
    public void connect() {
        System.out.println("Connecting");
    }

    public List<?> query(String ... stmt){
        List<String> lst = new ArrayList<>(); 
        lst.addAll(Arrays.asList(stmt));
        lst.addAll(Arrays.asList("A","B","C"));
        return lst;
    }

}