import java.util.List;
import org.springframework.beans.factory.annotation.Value;

public interface PersonProjection {
    @Value("#{target.id}")
    Integer getId();
    String getName();
    String getLastname();
    List<ContactInfo> getContactInfoList();
}