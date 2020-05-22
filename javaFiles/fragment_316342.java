public interface IRepository extends CrudRepository<MyClass, UUID> {
    // ...
    default void delByFecha(LocalDate fecha) {

        deleteByFechaBetween(fecha.atStartOfDay(), fecha.plusDays(1).atStartOfDay());

    }

    void deleteByFechaBetween(LocalDateTime from, LocalDateTime to);
    // ...
}