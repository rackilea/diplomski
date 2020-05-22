import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface DecisionDao {

     Decision create(@Valid @NotNull @Size(min = 1) String name,
            String description, String url, String imageUrl);
}