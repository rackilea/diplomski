import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton // optional
public class Dog {

    public void talk() {
        System.out.println("wowowo~ ฅ^•ﻌ•^ฅ");
    }
}