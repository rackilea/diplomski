import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private Utility utility;

    public String showResult() {
        String result = utility.getName();
        return result;
    }
}