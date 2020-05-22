package ejbtest.utility;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class Utility {
    int count = 0;

    @PostConstruct
    public void init() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}