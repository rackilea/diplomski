public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    static Specification<User> containing(String columnName,  List<String> values) {
        return (root, query, builder) -> values.stream()
                .map(v -> builder.like(root.get(columnName), "%" + v + "%"))
                .reduce(builder::or)
                .orElseGet(builder::conjunction);
    }