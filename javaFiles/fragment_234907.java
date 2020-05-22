public class DelegationSpecificationsHelper {

    public static Specification<Domain> notificationContactSpec(String contact) {
        return (root, query, cb) -> cb.equal(root.join("notification").get("contact"), contact);
    }

    public static Specification<Domain> idSpec(SearchCriteria searchCriteria) {
        switch (criteria.getOperation()) {
          case ":":
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
              return builder.like(
                      root.<String>get(criteria.getKey()),
                      "%" + criteria.getValue() + "%");
            } else {
              return builder.equal(root.get(criteria.getKey()),
                      criteria.getValue());
            }
          case "=":
            return builder.equal(root.get(criteria.getKey()),
                    criteria.getValue());
          default:
            return null;
        }
    }
}