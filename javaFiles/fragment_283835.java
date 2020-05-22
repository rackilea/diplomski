import java.util.ArrayList;
import java.util.List;

class Data {
    int timestamp;
    int user;

    Data(int ts, int user) {
        this.timestamp = ts;
        this.user = user;
    }
}

public class Test {

    public static void main(String[] args) {
        List<Data> data = new ArrayList<Data>();
        Data d1 = new Data(201612312, 123);
        Data d2 = new Data(201612312, 123);
        data.add(d1);
        data.add(d2);

        System.out.println(data.get(1).user);
    }
}