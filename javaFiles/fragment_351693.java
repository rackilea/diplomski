import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class DecisionDaoImpl extends BaseDao implements DecisionDao {

    @Override
    public Decision create(String name,
            String description, String url, String imageUrl) {
        System.out.println(name);
        return new Decision();
    }

}