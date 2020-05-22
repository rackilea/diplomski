@Repository
public interface CropVarietyNameDao extends JpaRepository<CropVarietyName, Long>,
        JpaSpecificationExecutor<CropVarietyName> {
}

public class CropVarietySpecs {

        public static Specification<CropVarietyName> cropPredicate(String varietyName, String sciName, boolean cropStatus) {
        return new Specification<CropVarietyName>() {
            @Override
            public Predicate toPredicate(Root<CropVarietyName> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                Predicate varietyContainingIgnoreCasePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("<column_name>")), varietyName.toLowerCase());
                Predicate scientificContainingIgnoreCasePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("<column_name>")), sciName.toLowerCase());
                Predicate cropStatusPredicate = criteriaBuilder.equal(root.get("<column_name>"), cropStatus);
                predicates.add(varietyContainingIgnoreCasePredicate);
                predicates.add(scientificContainingIgnoreCasePredicate);
                criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
                return criteriaBuilder.and(cropStatusPredicate);
            }
        };

    }
}