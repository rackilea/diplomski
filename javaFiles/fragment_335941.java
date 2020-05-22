import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;     
public interface ReportVocalOrderRepository extends MongoRepository<ReportVocalOrder, String> {

    List<ReportVocalOrder> findByDateBetweenAndOfferTypeIn(Date startDate, Date endDate, List<String> offers, Pageable pageable);


}