public interface BudgetRepository extends JpaRepository<Budget,Long> {

    List<Budget> findAll();

    List<Budget> findByUserLogin(String login);
}