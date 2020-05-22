public interface ParentRepo extends JpaRepository<Parent, Long> {

    Long countByChildren_Parent(Parent parent);

    @Query("select count(c) from Parent p join p.children c where p = ?1")
    Long countChildrenByParent(Parent parent);

    Long countByChildren_ParentId(Long id);

    @Query("select count(c) from Parent p join p.children c where p.id = ?1")
    Long countChildrenByParentId(Long id);
}

public interface ChildRepo extends JpaRepository<Child, Long> {

    Long countByParent(Parent parent);

    @Query("select count(c) from Child c where c.parent = ?1")
    Long countChildrenByParent(Parent parent);

    Long countByParentId(Long id);

    @Query("select count(c) from Child c where c.parent.id = ?1")
    Long countChildrenByParentId(Long id);
}