@Repository
public interface BoardCardRepository extends JpaRepository<BoardCard, Long>, QueryDslPredicateExecutor<BoardCard> {

    @Query(value = "SELECT id.card.id FROM BoardCard WHERE id.board.id = :boardId AND onHold = true")
    List<Long> getExcludedCardIds(@Param("boardId") Long boardId);
}